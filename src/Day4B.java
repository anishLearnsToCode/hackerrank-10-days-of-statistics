import java.util.Scanner;

public class Day4B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int probabilityDefectivePercentage = scanner.nextInt();
        int numberOfPistons = scanner.nextInt();
        double probabilityDefective = (double) probabilityDefectivePercentage / 100;
        System.out.println(round(atMostN(numberOfPistons, 2, probabilityDefective)));
        System.out.println(round(atLeastN(numberOfPistons, 2, probabilityDefective)));
    }

    private static double round(double value) {
        return (double) Math.round(value * 1_000) / 1_000;
    }

    private static double atMostN(int n, int r, double p) {
        double result = 0, q = 1 - p;
        for (int i = 0 ; i <= r ; i++) {
            result += P(n, i, p, q);
        }
        return result;
    }

    private static double atLeastN(int n, int r, double p) {
        return 1 - atMostN(n, r - 1, p);
    }

    private static double P(int n, int r, double p, double q) {
        return C(n, r) * Math.pow(p, r) * Math.pow(q, n - r);
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
