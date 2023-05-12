import java.text.NumberFormat;

public class Ln implements Function {
    private final Function innerFunction;

    public Ln(Function innerFunction) {
        this.innerFunction = innerFunction;
    }

    @Override
    public double calculate(double x) {
        return Math.log(innerFunction.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Power(innerFunction, -1), innerFunction.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("ln(%s)", innerFunction.toPrettyString(nf));
    }
}