// Spearman's Rank Correlation Coefficient

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Day7B {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int length = SCANNER.nextInt();
        double[] X = getArray(length);
        double[] Y = getArray(length);
        double result = spearmanRankCorrelationCoefficient(X, Y);
        System.out.println(round(result));
    }

    private static double round(double value) {
        return (double) Math.round(value * 1_000) / 1_000;
    }

    private static double spearmanRankCorrelationCoefficient(double[] X, double[] Y) {
        int[] rankX = rank(X);
        int[] rankY = rank(Y);
        double d = squaredDifferenceSum(rankX, rankY);
        double n = X.length;
        return 1 - (6 * d) / (n * (n * n - 1));
    }

    private static int[] rank(double[] data) {
        Set<Double> uniqueElements = new HashSet<Double>();
        for (double element : data) {
            uniqueElements.add(element);
        }
        List<Double> sortedElements = new ArrayList<>(uniqueElements);
        sortedElements.sort(Double::compareTo);
        Map<Double, Integer> elementIndices = new HashMap<>();
        for (int index = 0 ; index < sortedElements.size() ; index++) {
            elementIndices.put(sortedElements.get(index), index + 1);
        }
        int[] rank = new int[data.length];
        for (int index = 0 ; index < data.length ; index++) {
            rank[index] = elementIndices.get(data[index]);
        }
        return rank;
    }

    private static double squaredDifferenceSum(int[] rankX, int[] rankY) {
        double sum = 0;
        for (int index = 0 ; index < rankX.length ; index++) {
            sum += Math.pow(rankX[index] - rankY[index], 2);
        }
        return sum;
    }

    private static double[] getArray(int length) {
        double[] array = new double[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = SCANNER.nextDouble();
        }
        return array;
    }
}
