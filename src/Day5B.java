import java.util.Scanner;

public class Day5B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double lambda1 = scanner.nextDouble();
        double lambda2 = scanner.nextDouble();
        double cost1 = 160 + 40 * (lambda1 + Math.pow(lambda1, 2));
        double cost2 = 128 + 40 * (lambda2 + Math.pow(lambda2, 2));
        System.out.println(round(cost1));
        System.out.println(round(cost2));
    }

    private static double round(double value) {
        return (double) Math.round(value * 1_000) / 1_000;
    }
}
