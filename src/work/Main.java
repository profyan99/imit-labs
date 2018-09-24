package work;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(new Locale("en"));
        /*func3(0, 0, 0);
        func3(0, 0, 3);
        func3(0, 2, 3);
        func3(2, -6, 4); // +
        func3(1, 4, 4); // +
        func3(1, 2, 3); // +*/

        /*func4(0,1,-0.1);
        func4(1,0,-0.1);
        func4(0,1,0.1); //+
        func4(0,0,0);
        func4(0,10,0);*/

        /*func5(0,0,0,0,0,0);
        System.out.println();
        func5(0,0,1,0,0,0);//
        func5(0,0,0,0,0,1);
        func5(0,0,1,0,0,1);
        func5(0,1,3,0,2,10);//
        func5(2,0,1,3,0,7);
        func5(1,1,1,2,2,3);
        func5(1,2,3,0,0,1);
        System.out.println();
        func5(0,2,2,0,4,4);
        func5(1,2,3,0,0,0);
        func5(1,2,3,2,4,6);
        func5(2,0,2,4,0,4);
        System.out.println();
        func5(1,2,3,4,5,6);*/


        func6(-10, 0.000001);
    }

    private static void func0() {
        System.out.println("Hello World!");
    }

    private static void func1(double first, double second, double third) {

        System.out.println(
                "Mult: " + first * second * third + " Av: " + (first + second + third) / 3f);
        if (first <= second && first <= third) {
            System.out.println(first);
            if (second < third) {
                System.out.println(second);
                System.out.println(third);
            } else {
                System.out.println(third);
                System.out.println(second);
            }
        } else if (second <= third && second <= first) {
            System.out.println(second);
            if (first < third) {
                System.out.println(first);
                System.out.println(third);
            } else {
                System.out.println(third);
                System.out.println(first);
            }
        } else {
            System.out.println(third);
            if (first < second) {
                System.out.println(first);
                System.out.println(second);
            } else {
                System.out.println(second);
                System.out.println(first);
            }
        }
    }

    private static void func2(int first, int second, int third) {

        System.out.println(
                "Mult: " + first * second * third + " Av: " + (first + second + third) / 3f);
        if (first <= second && first <= third) {
            System.out.println(first);
            if (second < third) {
                System.out.println(second);
                System.out.println(third);
            } else {
                System.out.println(third);
                System.out.println(second);
            }
        } else if (second <= third) {
            System.out.println(second);
            if (first < third) {
                System.out.println(first);
                System.out.println(third);
            } else {
                System.out.println(third);
                System.out.println(first);
            }
        } else {
            System.out.println(third);
            if (first < second) {
                System.out.println(first);
                System.out.println(second);
            } else {
                System.out.println(second);
                System.out.println(first);
            }
        }
    }

    private static void func3(double _a, double _b, double _c) {
        double d;

        if (_a == 0) {
            if (_b == 0) {
                System.out.println("Infinity roots");
            } else {
                System.out.println("1 root: " + (-_c / _b));
            }
        } else {
            d = _b * _b - 4 * _a * _c;
            if (d < 0) {
                System.out.println("No roots");
            } else if (d == 0) {
                System.out.println("1 root: \n " + (-_b) / (2 * _a));
            } else {
                System.out.println("2 roots: \n " + (-_b + Math.sqrt(d)) / (2 * _a) + "\n " + (-_b - Math.sqrt(d)) / (2 * _a));
            }
        }

    }

    private static void func4(double st, double min, double max) {
        if (st == 0 || (min > max && st > 0) || (min < max && st < 0)) {
            throw new RuntimeException("Invalid input data");
        }
        System.out.println("Tabulation of sin()");
        for (double val = min; Math.abs(val - max) > 0.0001f; val += st) {
            System.out.printf("%.6f   %.6f\n", val, Math.sin(val));
        }

    }

    private static void func5(double firstKoefTop, double secondKoefTop, double freeKoefTop,
                              double firstKoefBot, double secondKoefBot, double freeKoefBot) {

        double baseDet = firstKoefTop * secondKoefBot - secondKoefTop * firstKoefBot;
        double firstDet = freeKoefTop * secondKoefBot - secondKoefTop * freeKoefBot;
        double secondDet = firstKoefTop * freeKoefBot - freeKoefTop * firstKoefBot;

        if (baseDet == 0) {
            if (firstDet == 0 && secondDet == 0) {
                System.out.println("Infinity roots");
            } else {
                System.out.println("No roots");
            }
        } else {
            System.out.println("first: " + firstDet / baseDet + " second: " + secondDet / baseDet);
        }
    }

    private static void func6(double accuracy, double x) {
        double summ = 1f;
        double current = 1f;
        for (int i = 1; Math.abs(current) > Math.abs(accuracy); i++) {
            current *= x / i;
            summ += current;
        }
        System.out.println("Answer: " + summ);
    }
}
