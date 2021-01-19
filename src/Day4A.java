import java.util.Scanner;

public class Day4A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ratioBoys = scanner.nextDouble();
        double ratioGirls = scanner.nextDouble();
        double probabilityBoys = ratioBoys / (ratioBoys + ratioGirls);
        double probabilityGirls = ratioGirls / (ratioBoys + ratioGirls);
        double result = 0;

        for (int i = 3 ; i <= 6 ; i++) {
            result += C(6, i) * Math.pow(probabilityBoys, i) * Math.pow(probabilityGirls, 6 - i);
        }

        System.out.println(round(result));
    }

    private static double round(double value) {
        return (double) Math.round(value * 1_000) / 1_000;
    }

    private static int C(int n, int r) {
        return factorial(n) / (factorial(n - r) * factorial(r));
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2 ; i <= n ; i++) {
            result *= i;
        }
        return result;
    }
}
