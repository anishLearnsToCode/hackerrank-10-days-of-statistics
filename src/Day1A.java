import java.util.Arrays;
import java.util.Scanner;

public class Day1A {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int length  = SCANNER.nextInt();
        int[] array = getArray(length);
        Arrays.sort(array);
        int[] left = arraySplit(array, 0, array.length / 2);
        int[] right = arraySplit(array, (int) Math.ceil((double) array.length / 2), array.length);
        System.out.println(median(left));
        System.out.println(median(array));
        System.out.println(median(right));
    }

    private static int median(int[] array) {
        int result = array[array.length / 2];
        if (array.length % 2 == 0) {
            result = (array[array.length / 2 - 1] + array[array.length / 2]) / 2;
        }
        return result;
    }

    private static int[] arraySplit(int[] array, int startIndex, int endIndex) {
        int[] result = new int[endIndex - startIndex];
        for (int index = startIndex ; index < endIndex ; index++) {
            result[index - startIndex] = array[index];
        }
        return result;
    }

    private static int[] getArray(int length) {
        int[] array = new int[length];
        for (int index = 0 ; index < length ; index++) {
            array[index] = SCANNER.nextInt();
        }
        return array;
    }
}
