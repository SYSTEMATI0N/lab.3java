
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Calculator {
    private static double a = 0.5;
    private static double b = -0.3;
    private static double x = -1.25;

    public static double f1(double x) {
        return Math.sqrt(Math.abs(a / Math.tan(x) - b * Math.tan(x))) + Math.pow(x + a, 3);
    }

    public static double f2(double x) {
        return x * Math.pow(Math.log(Math.abs(a * Math.sin(x) + b * Math.cos(x))), 2);
    }

    public static void setInputValues(double a, double b, double x) {
        Calculator.a = a;
        Calculator.b = b;
        Calculator.x = x;
    }

    public static void inputValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        a = scanner.nextDouble();
        System.out.print("Enter b: ");
        b = scanner.nextDouble();
        System.out.print("Enter x: ");
        x = scanner.nextDouble();
       // scanner.close();
    }

    public static void displayInputValues() {
        System.out.println("a = " + a + ", b = " + b + ", x = " + x);
    }

    public static void displayDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yy");
        Date date = new Date();
        System.out.println(formatter.format(date));
    }

    public static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Input values");
        System.out.println("2. Display input values");
        System.out.println("3. Calculate and display f1 and f2");
        System.out.println("4. Display current date and time");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputValues();
                    break;
                case 2:
                    displayInputValues();
                    break;
                case 3:
                    System.out.println("f1(x) = " + f1(x));
                    System.out.println("f2(x) = " + f2(x));
                    break;
                case 4:
                    displayDateTime();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}