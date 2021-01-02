package lab4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
 * <p>
 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
 * <p>
 * Given A = [1, 2, 3], the function should return 4.
 * <p>
 * Given A = [−1, −3], the function should return 1.
 */
public class Lab4 {

    public static void main(String args[]) {

        int data[] = {1, 3, 6, 4, 1, 2};


        boolean found = false;
        int index = 1;
        int result = 0;
        while (!found) {
            if (contains(data, index)) {
                index++;
            } else {
                found = true;
                result = index;
            }
        }

        System.out.println(result);

    }

    public static boolean contains(int data[], int target) {
        boolean found = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                found = true;
            }
        }
        return found;
    }
}
