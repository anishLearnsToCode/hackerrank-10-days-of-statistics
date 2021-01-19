// Geometric Distribution II

import java.util.Scanner;

public class Day4D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = scanner.nextInt();
        int denominator = scanner.nextInt();
        int maxInspections = scanner.nextInt();
        double probabilityDefect = (double) numerator / denominator;
        double probabilityFine = 1 - probabilityDefect;
        double result = 0;
        for (int i = 0 ; i < maxInspections ; i++) {
            result += Math.pow(probabilityFine, i) * probabilityDefect;
        }
        System.out.println(round(result));
    }

    private static double round(double value) {
        return (double) Math.round(value * 1_000) / 1_000;
    }
}
