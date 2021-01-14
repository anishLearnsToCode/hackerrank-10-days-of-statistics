import java.util.Arrays;
import java.util.Scanner;

public class Day0B {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        int[] weights = getArray(length);
        System.out.println(weightedMean(array, weights));
    }

    private static double weightedMean(int[] array, int[] weights) {
        double sum = 0;
        for (int index = 0 ; index < array.length ; index++) {
            sum += array[index] * weights[index];
        }
        return round(sum / Arrays.stream(weights).sum());
    }

    private static double round(double value) {
        return (double) Math.round(value * 10) / 10;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = scanner.nextInt();
        }
        return array;
    }
}
