import java.text.NumberFormat;

public class Tg implements Function {
    private final Function innerFunction;

    public Tg(Function innerFunction) {
        this.innerFunction = innerFunction;
    }

    @Override
    public double calculate(double x) {
        return Math.tan(innerFunction.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Power(new Cos(innerFunction), -2), innerFunction.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("tg(%s)", innerFunction.toPrettyString(nf));
    }
}