package algorithms.sorts;

import java.util.Arrays;

public class MergeSort {

    private static int[] merge(int[] array1, int[] array2) {
        int i = 0, j = 0, m = 0;
        int[] merged = new int[array1.length + array2.length];
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                merged[m++] = array1[i++];
            } else {
                merged[m++] = array2[j++];
            }
        }
        while (i < array1.length) {
            merged[m++] = array1[i++];
        }
        while (j < array2.length) {
            merged[m++] = array2[j++];
        }
        return merged;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) return array;

        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    public static void main(String[] args) {
        int[] array = {999, 888, 6, 4, 7, 3, 886, 4, 1};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(mergeSort(array)));
    }
}
