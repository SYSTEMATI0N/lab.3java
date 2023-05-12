import java.text.NumberFormat;

public class CompositeFunction implements Function {
    private final Function outerFunction;
    private final Function innerFunction;

    public CompositeFunction(Function outerFunction, Function innerFunction) {
        this.outerFunction = outerFunction;
        this.innerFunction = innerFunction;
    }

    @Override
    public double calculate(double x) {
        return outerFunction.calculate(innerFunction.calculate(x));
    }

    @Override
    public Function derivative() {
        return new Multiplication(outerFunction.derivative(), innerFunction.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("%s(%s)", outerFunction.toPrettyString(nf), innerFunction.toPrettyString(nf));
    }
}