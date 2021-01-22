import java.util.Arrays;
import java.util.Scanner;

public class Day8A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 5;
        double[] X = new double[n];
        double[] Y = new double[n];
        for (int i = 0 ; i < n ; i++){
            X[i] = scanner.nextInt();
            Y[i] = scanner.nextInt();
        }
        DescriptiveStatistics descriptionX = new DescriptiveStatistics(X);
        DescriptiveStatistics descriptionY = new DescriptiveStatistics(Y);
        double b = pearsonCoefficient(descriptionX, descriptionY) * (descriptionY.standardDeviation / descriptionX.standardDeviation);
        double a = descriptionY.mean - b * descriptionX.mean;
        double x = 80;
        double y = a + b * x;
        System.out.println(round(y));
    }

    private static double round(double value) {
        return (double) Math.round(value * 1_000) / 1_000;
    }

    private static double pearsonCoefficient(DescriptiveStatistics X, DescriptiveStatistics Y) {
        double covariance = cov(X, Y);
        return covariance / (X.length() * X.standardDeviation * Y.standardDeviation);
    }

    private static double cov(DescriptiveStatistics X, DescriptiveStatistics Y) {
        double sum = 0;
        for (int index = 0 ; index < X.length() ; index++) {
            sum += (X.get(index) - X.mean) * (Y.get(index) - Y.mean);
        }
        return sum;
    }

    private static final class DescriptiveStatistics {
        final double mean;
        final double variance ;
        final double standardDeviation;
        final double[] data;

        DescriptiveStatistics(double[] data) {
            this.mean = Arrays.stream(data).sum() / data.length;
            this.variance = variance(data);
            this.standardDeviation = Math.sqrt(this.variance);
            this.data = data;
        }

        private double variance(double[] data) {
            double sum = 0;
            for (double element : data) {
                sum += Math.pow(element - mean, 2);
            }
            return sum / data.length;
        }

        private int length() {
            return this.data.length;
        }

        private double get(int index) {
            return this.data[index];
        }
    }
}
