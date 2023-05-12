import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Multiplication extends Composite {
    public Multiplication() {
        super();
    }

    public Multiplication(Function... terms) {
        super(terms);
    }

    public Multiplication(ArrayList<Function> terms) {
        super(terms);
    }

    @Override
    public double calculate(double x) {
        double result = 1.0;
        for (Function function : terms()) {
            result *= function.calculate(x);
        }
        return result;
    }

    @Override
    public Function derivative() {
        final ArrayList<Function> derivativeTerms = new ArrayList<>(terms().size());
        for (int i = 0; i < terms().size(); i++) {
            final ArrayList<Function> newTerms = new ArrayList<>(terms().size());
            for (int j = 0; j < terms().size(); j++) {
                if (i == j) {
                    newTerms.add(terms().get(j).derivative());
                } else {
                    newTerms.add(terms().get(j));
                }
            }
            derivativeTerms.add(new Multiplication(newTerms));
        }
        return new Sum(derivativeTerms);
    }

    @Override
    public String toPrettyString(NumberFormat nf) {
        final StringJoiner joiner = new StringJoiner("*");
        for (Function function : terms()) {
            joiner.add(function.toPrettyString(nf));
        }
        return String.format("(%s)", joiner.toString());
    }

    public static Multiplication of(Function... terms) {
        return new Multiplication(terms);
    }
}