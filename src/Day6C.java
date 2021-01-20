import java.util.Scanner;

public class Day6C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double samples = scanner.nextDouble();
        double mean = scanner.nextDouble();
        double std = scanner.nextDouble();
        double interval = scanner.nextDouble();
        double z = scanner.nextDouble();
        double stdSample = std / Math.sqrt(samples);

        System.out.println(round(mean - stdSample * z));
        System.out.println(round(mean + stdSample * z));
    }

    private static double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}
