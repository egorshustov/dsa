package algorithms.sorts;

import java.util.Arrays;

public class QuickSort {

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;
        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                ++swapIndex;
                swap(array, swapIndex, i);
            }
        }
        swap(array, swapIndex, pivotIndex);
        return swapIndex;
    }

    private static void quickSortHelper(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) return;
        int pivotIndex = pivot(array, leftIndex, rightIndex);
        quickSortHelper(array, leftIndex, pivotIndex - 1);
        quickSortHelper(array, pivotIndex + 1, rightIndex);
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        int[] array = {4, 6, 1, 7, 3, 2, 5};
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
