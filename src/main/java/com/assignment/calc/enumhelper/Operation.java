package com.assignment.calc.enumhelper;

public enum Operation {
    ADD {
        @Override
        public Number apply (Number num1, Number num2) {
            return num1.doubleValue() + num2.doubleValue();
        }
    },
    SUBTRACT {
        @Override
        public Number apply (Number num1, Number num2) {
            return num1.doubleValue() - num2.doubleValue();
        }
    },
    MULTIPLY {
        @Override
        public Number apply (Number num1, Number num2) {
            return num1.doubleValue() * num2.doubleValue();
        }
    },
    DIVIDE {
        @Override
        public Number apply (Number num1, Number num2) {
            return num1.doubleValue() / num2.doubleValue();
        }
    };


    public abstract Number apply(Number num1, Number num2);
}
