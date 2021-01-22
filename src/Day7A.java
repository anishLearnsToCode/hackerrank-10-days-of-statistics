// Pearson Correlation Coefficient I

import java.util.Arrays;
import java.util.Scanner;

public class Day7A {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int length = SCANNER.nextInt();
        double[] X = getArray(length);
        double[] Y = getArray(length);
        double result = pearsonCoefficient(X, Y);
        System.out.println(round(result));
    }

    private static double round(double value) {
        return (double) Math.round(value * 1_000) / 1_000;
    }

    private static double[] getArray(int length) {
        double[] array = new double[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = SCANNER.nextDouble();
        }
        return array;
    }

    private static double pearsonCoefficient(double[] X, double[] Y) {
        DescriptiveStatistics descriptionX = new DescriptiveStatistics(X);
        DescriptiveStatistics descriptionY = new DescriptiveStatistics(Y);
        double covariance = cov(descriptionX, descriptionY);
        return covariance / (X.length * descriptionX.standardDeviation * descriptionY.standardDeviation);
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
