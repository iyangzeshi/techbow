package bq_resume.calculator_factory_pattern.operation;

public enum Operator {
    add("+"),
    sub("-"),
    multi("*"),
    div("/");

    private final String symbol;

    Operator(final String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
