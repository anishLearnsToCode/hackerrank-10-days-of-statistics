import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day1B {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int length = SCANNER.nextInt();
        int[] X = getArray(length);
        int[] F = getArray(length);
        List<Integer> data = createFrequencyArray(X, F);
        data.sort(Integer::compareTo);
        int[] left = arraySplit(data, 0, data.size() / 2);
        int[] right = arraySplit(data, (data.size() + 1) / 2, data.size());
        double quartile1 = median(left);
        double quartile3 = median(right);
        double result = quartile3 - quartile1;
        System.out.println(round(result));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = SCANNER.nextInt();
        }
        return array;
    }

    private static int[] arraySplit(List<Integer> data, int startIndex, int endIndex) {
        int[] array = new int[endIndex - startIndex];
        for (int index = startIndex ; index < endIndex ; index++) {
            array[index - startIndex] = data.get(index);
        }
        return array;
    }

    private static double round(double value) {
        return (double) Math.round(value * 10) / 10;
    }

    private static double median(int[] data) {
        double result = data[data.length / 2];
        if (data.length % 2 == 0) {
            result = ((double) data[data.length / 2 - 1] + data[data.length / 2]) / 2;
        }
        return result;
    }

    private static List<Integer> createFrequencyArray(int[] X, int[] F) {
        List<Integer> data = new ArrayList<>(X.length * F.length);
        for (int index = 0 ; index < X.length ; index++) {
            for (int i = 0 ; i < F[index] ; i++) {
                data.add(X[index]);
            }
        }
        return data;
    }
}
