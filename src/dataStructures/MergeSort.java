package dataStructures;

public class MergeSort {

    public static void main(String args[]) {


        int arr[] = {10, 2, 6, 1, 3, 4, 5, 8, 9, 7, 0};
        //output = 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        //int arr[] = {10, 6, 8, 5, 7, 3, 4};
        //output = 3, 4, 5, 6, 7, 8, 10
        MergeSort.mergeSort(arr, arr.length);
        printArray(arr);
    }


    static void mergeSort(int arr[], int n) {

        if (n < 2) {
            return;
        }

        int mid = n / 2;
        System.out.print(mid);
        int left[] = new int[mid];
        int right[] = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int i = mid; i < n; i++) {
            right[i - mid] = arr[i];
        }

        mergeSort(left, mid);
        mergeSort(right, n - mid);
        merge(arr, left, right, mid, n - mid);

    }

    static void merge(int[] arr, int[] left, int[] right, int nl, int nr) {

        int i = 0, j = 0, k = 0;
        while (i < nl && j < nr) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < nl) {
            arr[k++] = left[i++];
        }
        while (j < nr) {
            arr[k++] = right[j++];
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}








