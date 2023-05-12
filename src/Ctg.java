import java.text.NumberFormat;

public class Ctg implements Function {
    private final Function innerFunction;

    public Ctg(Function innerFunction) {
        this.innerFunction = innerFunction;
    }

    @Override
    public double calculate(double x) {
        return 1.0 / Math.tan(innerFunction.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Const(-1), new Power(new Sin(innerFunction), -2), innerFunction.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("ctg(%s)", innerFunction.toPrettyString(nf));
    }
}