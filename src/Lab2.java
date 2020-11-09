/**
 * Dado el siguiente array [0,0,0,1,0,99] se debe avanzar hasta el
 * número 99 para poder ganar el juego, pero si se encuentra con el número 1,
 * no puede avanzar, pero puede recurrir a un salto de n posiciones solo una vez, si
 * vuelve y cae en un número 1, entonces se da como perdido el juego.
 */

public class Lab2 {

    private final static int data[] = {0, 0, 0, 1, 0, 99};
    private final static int skips = 2;
    //private final static int data[] = {0, 0, 0, 1, 1, 1, 0, 99};
    //private final static int skips = 3;
    private final static int length = data.length;

    public static void main(String[] args) {

        boolean playing = length > 0;
        boolean hasSkip = true;
        int position = 0;
        int value = 0;

        while (playing) {
            value = data[position];
            switch (value) {
                case 0:
                    position = forward(position);
                    break;
                case 1:
                    if (hasSkip) {
                        position = skip(position);
                        hasSkip = false;
                    } else {
                        playing = false;
                    }
                    break;
                case 99:
                    playing = false;
                    break;
            }
        }

        printState(value);
    }

    private static int forward(int position) {
        final int forwardPosition = position + 1;
        if (forwardPosition < length) return forwardPosition;
        else return position;
    }

    //private static int backward(int position) {
    //  final int backwardPosition = position - 1;
    //if (backwardPosition > 0) return backwardPosition;
    //else return position;
    //}

    private static int skip(int position) {
        final int skipPosition = (position + skips) - 1;
        if (skipPosition < length) return skipPosition;
        else return position;
    }

    //private static boolean isOver(int value) {
    //  return value == 99;
    //}

    private static void printState(int value) {
        if (value == 99) {
            System.out.println("You win!. Game over.");
        } else {
            System.out.println("Game over. You lost!");
        }
    }
}
