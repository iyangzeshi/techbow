package bq_resume.calculator_factory_pattern;


import bq_resume.calculator_factory_pattern.operation.Operation;
import bq_resume.calculator_factory_pattern.operation.Operator;

public class CalculatorUI {

    public double calculateDouble(final double number1, final Operator operator, final double number2) {
        final Operation operation = OperationFactory.createOperation(operator);
        assert operation != null;
        return operation.getResult(number1, number2);
    }
}
