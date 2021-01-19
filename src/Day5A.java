// Poisson Distribution I

import java.util.Scanner;

public class Day5A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lambda = scanner.nextDouble();
        int k = scanner.nextInt();
        double result = (Math.pow(lambda, k) * Math.exp(-lambda)) / factorial(k);
        System.out.println(round(result));
    }

    private static double round(double value){
        return (double) Math.round(value * 1_000) / 1_000;
    }

    private static int factorial(int n) {
        int result = 1;
        for (int i = 2 ; i <= n ; i++) {
            result *= i;
        }
        return result;
    }
}
