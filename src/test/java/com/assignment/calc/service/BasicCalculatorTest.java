package com.assignment.calc.service;

import com.assignment.calc.CalculatorConfig;
import com.assignment.calc.enumhelper.Operation;
import com.assignment.calc.service.impl.BasicCalculator;
import com.assignment.calc.service.impl.ChainingCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@ContextConfiguration(classes = CalculatorConfig.class)
class BasicCalculatorTest {
    @Test
    void testBasicCalculation1() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate(Operation.ADD, 1, 2);
        assertEquals(3.0, result);
    }

    @Test
    void testBasicCalculation2() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate(Operation.SUBTRACT, 5, 1);
        assertEquals(4.0, result);
    }

    @Test

    void testBasicCalculation3() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate(Operation.MULTIPLY, 3.2, 2);
        assertEquals(6.4, result);
    }

    @Test
    void testBasicCalculation4() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate(Operation.DIVIDE, 1, 2);
        assertEquals(0.5, result);
    }

    @Test
    void testBasicCalculation5() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate(Operation.MULTIPLY, 0, 2);
        assertEquals(0.0, result);
    }

    @Test
    void testBasicCalculation6() {
        Calculator calculator = new BasicCalculator();
        Number result = calculator.calculate("ADD", 100.2, 2);
        assertEquals(102.2, result);
    }

    @Test
    void testBasicCalculation7() {
        Calculator calculator = new BasicCalculator();
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate("ADDITION", 1, 2));
    }

    @Test
    void testBasicCalculation8() {
        Number result = ChainingCalculator.builderInstance(1)
                            .apply("Add", 2)
                            .apply(Operation.DIVIDE, 2)
                            .apply(Operation.MULTIPLY, 10)
                            .apply(Operation.SUBTRACT, 2)
                            .evaluate();
        assertEquals(13.0, result);
    }


    @Test
    void testBasicCalculation9() {
        ChainingCalculator.Builder builder = ChainingCalculator.builderInstance(1);
        assertThrows(UnsupportedOperationException.class,
                            () -> ChainingCalculator.builderInstance(1)
                                    .apply("Add", 2)
                                    .apply("Division", 2)
                                    .apply(Operation.MULTIPLY, 10)
                                    .apply(Operation.SUBTRACT, 2)
                                    .evaluate());
    }

}
