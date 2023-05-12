import java.text.NumberFormat;

public class Sin implements Function {
    private final Function innerFunction;

    public Sin(Function innerFunction) {
        this.innerFunction = innerFunction;
    }

    @Override
    public double calculate(double x) {
        return Math.sin(innerFunction.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Cos(innerFunction), innerFunction.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sin(%s)", innerFunction.toPrettyString(nf));
    }
}