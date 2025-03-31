package com.assignment.calc.service.impl;

import com.assignment.calc.enumhelper.Operation;
import com.assignment.calc.service.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasicCalculator implements Calculator {
    Logger logger = LoggerFactory.getLogger(BasicCalculator.class);

    @Override
    public Number calculate(Operation op, Number num1, Number num2) {
        logger.debug("Operation: {}, Operand-1: {}, Operand-2: {}", op.name(), num1.doubleValue(), num2.doubleValue());
        return op.apply(num1, num2);
    }

    @Override
    public Number calculate(String op, Number num1, Number num2) {
        return calculate(getOperation(op), num1, num2);
    }

    public Operation getOperation(String opStr) {
        try {
            return Operation.valueOf(opStr.toUpperCase());
        } catch (Exception e) {
            String msg = String.format("Operation - %s - is not supported yet", opStr);
            logger.error(msg);
            throw new UnsupportedOperationException(msg);
        }
    }
}
