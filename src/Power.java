import java.text.NumberFormat;

public class Power implements Function {
    private final Function base;
    private final double exponent;

    public Power(Function base, double exponent) {
        this.base = base;
        this.exponent = exponent;
    }

    @Override
    public double calculate(double x) {
        return Math.pow(base.calculate(x), exponent);
    }

    @Override
    public Function derivative() {
        return new Multiplication(new Const(exponent), new Power(base, exponent - 1), base.derivative());
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        return String.format("(%s)^%s", base.toPrettyString(nf), nf.format(exponent));
    }
}
