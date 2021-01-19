// Geometric Distribution I

import java.util.Scanner;

public class Day4C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numerator = scanner.nextInt();
        int denominator = scanner.nextInt();
        int inspectionNumber = scanner.nextInt();
        double probabilityDefect = (double) numerator / denominator;
        double probabilityFine = 1 - probabilityDefect;
        double result = Math.pow(probabilityFine, inspectionNumber - 1) * probabilityDefect;
        System.out.println(round(result));
    }

    private static double round(double value) {
        return (double) Math.round(value * 1_000) / 1_000;
    }
}
