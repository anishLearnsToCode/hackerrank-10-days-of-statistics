import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day0A {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = scanner.nextInt();
        int[] array = getArray(length);
        System.out.println(mean(array));
        System.out.println(median(array));
        System.out.println(mode(array));
    }

    private static double mean(int[] array) {
        return round((double) Arrays.stream(array).sum() / array.length);
    }

    private static double median(int[] array) {
        Arrays.sort(array);
        double result = array[array.length / 2];
        if (array.length % 2 == 0) {
            result = ((double) array[array.length / 2 - 1] + array[array.length / 2]) / 2 ;
        }
        return round(result);
    }

    private static int mode(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number : array) {
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
        }
        int maxFrequency = frequencies.values().stream().max(Integer::compareTo).get();
        int currentMin = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            int number = entry.getKey(), frequency = entry.getValue();
            if (frequency == maxFrequency && number < currentMin) {
                currentMin = number;
            }
        }
        return currentMin;
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
