package dataStructures;

public class BinarySearch {

    public static void main(String args[]) {

        //int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr[] = {6, 7, 8, 9, 10, 11, 14, 15, 17, 19, 22, 23, 25, 28, 30};
        //int arr[] = { 2, 3, 4, 10, 40 };
        //int arr[] = { 2};
        int input = 16;
        int index = search(arr, input, 0, arr.length);
        if (index > -1) {
            System.out.printf("Target %s found at index %s", arr[index], index);
        } else {
            System.out.printf("Target %s don't found!", input);
        }

    }

    public static int search(int arr[], int input, int start, int end) {

        if (start >= end) {
            return -1;
        }

        int middle = (start + end) / 2;

        if (arr[middle] == input) {
            return middle;
        } else if (input < arr[middle]) {
            return search(arr, input, start, end - 1);
        } else {
            return search(arr, input, start + 1, end);
        }

    }

}
