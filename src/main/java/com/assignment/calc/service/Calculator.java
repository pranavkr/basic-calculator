package com.assignment.calc.service;

import com.assignment.calc.enumhelper.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Calculator {
    Logger logger = LoggerFactory.getLogger(Calculator.class);

    /**
     * To perform given operation on provided operands
     *
     * @param op {@link Operation} to be performed on given operands
     * @param num1 1st operand
     * @param num2 2nd operand
     * @return result of {@code op} performed over {@code num1} and {@code num2}
     */
    default Number calculate(Operation op, Number num1, Number num2) {
        String msg = "calculate method is not supported as of date.";
        logger.info(msg);
        throw new UnsupportedOperationException(msg);
    }

    /**
     * To perform given operation on provided operands.
     * This is an overloaded method to {@link Calculator#calculate(Operation, Number, Number)}
     *
     * @param op   String representing {@link Operation}, to be performed on given operands
     * @param num1 1st operand
     * @param num2 2nd operand
     * @return result of {@code op} performed over {@code num1} and {@code num2}
     */
    default Number calculate(String op, Number num1, Number num2) {
        String msg = "calculate method is not supported as of date.";
        logger.info(msg);
        throw new UnsupportedOperationException(msg);
    }
}

