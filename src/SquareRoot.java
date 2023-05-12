import java.text.NumberFormat;

public class SquareRoot implements Function {
    private final Function innerFunction;

    public SquareRoot(Function innerFunction) {
        this.innerFunction = innerFunction;
    }

    @Override
    public double calculate(double x) {
        return Math.sqrt(Math.abs(innerFunction.calculate(x)));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Const(0.5), new Multiplication(new Power(innerFunction, -0.5), innerFunction.derivative()));
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("sqrt(|%s|)", innerFunction.toPrettyString(nf));
    }
}
