import java.text.NumberFormat;

public class AbsoluteValue implements Function {
    private final Function innerFunction;

    public AbsoluteValue(Function innerFunction) {
        this.innerFunction = innerFunction;
    }

    @Override
    public double calculate(double x) {
        return Math.abs(innerFunction.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Power(innerFunction, -1), innerFunction.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("|%s|", innerFunction.toPrettyString(nf));
    }
}