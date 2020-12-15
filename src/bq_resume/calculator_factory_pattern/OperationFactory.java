package bq_resume.calculator_factory_pattern;

import bq_resume.calculator_factory_pattern.operation.*;

public class OperationFactory {
    public static Operation createOperation(final Operator operator) {
        switch (operator) {
            case add:
                return new OperationAdd();
            case sub:
                return new OperationSub();
            case multi:
                return new OperationMulti();
            case div:
                return new OperationDiv();
            default:
                return null;
        }
    }
}
