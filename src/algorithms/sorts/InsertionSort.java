package algorithms.sorts;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j >= 0 && temp < array[j]) {
                array[j + 1] = array[j];
                array[j] = temp;
                --j;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {999, 888, 6, 4, 7, 3, 886, 4, 1};
        System.out.println(Arrays.toString(array));
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
