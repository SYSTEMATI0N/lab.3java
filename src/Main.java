import java.text.NumberFormat;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final double a = 0.5;
        final double b = -0.3;
        final double x = -1.25;

        final Function f1 = new CompositeFunction(new SquareRoot(new AbsoluteValue(new Sum(new Multiplication(new Const(a), new Ctg(new Linear(x))), new Multiplication(new Const(b), new Tg(new Linear(x)))))), new Sum(new Power(new Sum(new Linear(a), new Const(x)), 3)));
        final Function f2 = new CompositeFunction(new Power(new Linear(x), 2), new Ln(new AbsoluteValue(new Sum(new Multiplication(new Const(a), new Sin(new Linear(x))), new Multiplication(new Const(b), new Cos(new Linear(x)))))));

        final NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(6);

        System.out.format("f1(x) = %s", f1.toPrettyString(nf)).println();
        System.out.format("f1'(x) = %s", f1.derivative().toPrettyString(nf)).println();
        System.out.format("f1'(%.2f) = %s",x, nf.format(f1.derivative().calculate(x))).println();

        System.out.format("f2(x) = %s", f2.toPrettyString(nf)).println();
        System.out.format("f2'(x) = %s", f2.derivative().toPrettyString(nf)).println();
        System.out.format("f2'(%.2f) = %s",x, nf.format(f2.derivative().calculate(x))).println();
    }
}