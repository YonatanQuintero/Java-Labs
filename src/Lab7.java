import java.util.Arrays;

public class Lab7 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-5, -4, -2, 12, -40, 4, 2, 18, 11, 5, -5}));//Result = 2
        int array[] = new int[]{-5, -4, -2, 12, -40, 4, 2, 18, 11, 5, -5, 3};
        Arrays.sort(array);
        System.out.println(array.toString());
        int i = Arrays.binarySearch(array, 3);
        System.out.println(array[i]);
    }

    public static int solution(int[] ints) {
        int closest = 0;
        for (int i = 0; i < ints.length; i++) {
            int value = ints[i];
            if (closest == 0) {
                closest = value;
            } else if (value > 0 && value <= Math.abs(closest)) {
                closest = value;
            } else if (value < 0 && -value < Math.abs(closest)) {
                closest = value;
            }
        }
        return closest;
    }
}
