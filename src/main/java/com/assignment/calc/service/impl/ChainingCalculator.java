package com.assignment.calc.service.impl;

import com.assignment.calc.enumhelper.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChainingCalculator extends BasicCalculator {

    public static Builder builderInstance(Number value) {
         ChainingCalculator calculator = new ChainingCalculator();
         return calculator.new Builder(value);
    }

    public class Builder {
        Logger logger = LoggerFactory.getLogger(Builder.class);

        private Number value;

        public Builder(Number value) {
            this.value = value;
        }


        /**
         * to get the value present with any Builder instance.
         *
         * @return the value present with given instance of Builder class
         */
        public Number evaluate() {
            if (null == this.value) {
                String msg = "evaluate method is being used without providing initial value";
                logger.info(msg);
                throw new IllegalStateException(msg);
            }
            return this.value;
        }

        /**
         * To perform chain of {@link Operation} over value present with instance.
         *
         * @param op {@link Operation} to be performed on value of {@code this} instance
         * @param operand 2nd operand (1st operand is present as the value of this instance)
         *
         * @return result of the {@code op} performed over value of this instance and {@code operand}
         */
        public Builder apply(Operation op, Number operand) {
            if (null == this.value) {
                String msg = "apply method is being used without providing initial value";
                logger.info(msg);
                throw new IllegalStateException(msg);
            }
            this.value = calculate(op, this.value, operand);
            return this;
        }

        /**
         * To perform chain of operation over value present with instance.
         *
         * @param op String equivalent to {@link Operation}, to be performed on value of {@code this} instance
         * @param operand 2nd operand (1st operand is present as the value of this instance)
         *
         * @return result of the {@code op} performed over value of this instance and {@code operand}
         */
        public Builder apply(String op, Number operand) {
            return apply(getOperation(op), operand);
        }
    }
}
