package algorithms;

public class CombinationWithoutRepetitions {

    public static void main(String args[]) {

        String input[] = {"A", "B", "C", "D", "E"};
        print(combinations(input, 3));
    }

    public static String[][] combinations(String input[], int r) {

        int c = getTotalCombinations(input.length, r);
        String[][] output = new String[c][r];
        helper(input, r, 0, 1, new String[r], output, 0);
        return output;

    }

    public static int helper(String input[], int r, int i, int n, String aux[], String[][] output, int k) {

        for (int j = i; j < input.length; j++) {
            aux[n - 1] = input[j];
            if (n < r) {
                k = helper(input, r, j + 1, n + 1, aux, output, k);
            } else {
                output[k++] = aux.clone();
            }
        }

        return k;
    }

    public static int getTotalCombinations(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    public static int factorial(int n) {
        if (n == 0) return 1;
        else return (n * factorial(n - 1));
    }

    public static void print(String input[][]) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j]);
                if (j < input[0].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("\n");
        }
    }
}
