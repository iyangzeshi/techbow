package bq_resume.calculator_factory_pattern.operation;

public class OperationAdd extends Operation {

    @Override
    public double getResult(double number1, double number2) {
        return number1 + number2;
    }
}
