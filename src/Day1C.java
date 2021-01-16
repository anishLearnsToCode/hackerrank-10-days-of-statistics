import java.util.Arrays;
import java.util.Scanner;

public class Day1C {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int length = SCANNER.nextInt();
        int[] array = getArray(length);
        double standardDeviation = standardDeviation(array);
        System.out.println(round(standardDeviation));
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = SCANNER.nextInt();
        }
        return array;
    }

    private static double round(double value) {
        return (double) Math.round(value * 10) / 10;
    }

    private static double standardDeviation(int[] data) {
        double mu = mean(data);
        double sum = 0;
        for (int element : data) {
            sum += Math.pow((element - mu), 2);
        }
        sum /= data.length;
        return Math.sqrt(sum);
    }

    private static double mean(int[] data) {
        return (double) Arrays.stream(data).sum() / data.length;
    }
}
