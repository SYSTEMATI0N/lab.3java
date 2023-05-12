import java.text.NumberFormat;

public class Cos implements Function {
    private final Function innerFunction;

    public Cos(Function innerFunction) {
        this.innerFunction = innerFunction;
    }

    @Override
    public double calculate(double x) {
        return Math.cos(innerFunction.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Const(-1), new Sin(innerFunction), innerFunction.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("cos(%s)", innerFunction.toPrettyString(nf));
    }
}