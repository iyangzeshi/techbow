package bq_resume.calculator_factory_pattern.operation;

public abstract class Operation {
    public Operation(){

    }

    public abstract double getResult(final double number1, final double number2);
}
