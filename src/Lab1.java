import java.util.LinkedList;
import java.util.List;

/**
 * Dado un string formado por (), [], {}, esribre un programa que indique si los pares
 * correspondientes son correctos.
 * Entrada: [()]{}{[()()]()} -> Correcto
 * Entrada: [(]) -> Incorrecto
 */

public class Lab1 {

    final static List<String> symbols = new LinkedList<String>() {{
        add("()");
        add("[]");
        add("{}");
    }};

    public static void main(String args[]) {
        final List<String> inputs = new LinkedList<String>() {{
            add("[()]{}{[()()]()}");
            add("[(])");
            add("[()]{}{[({})()]()}");
            add("[()]{}{[({})[(})]()}");
        }};

        inputs.forEach(input -> {
            correctPairs(input);
        });
    }

    private static void correctPairs(String input) {

        String auxInput = input;
        String subString = null;
        int length = auxInput.length();
        int index = 0;
        int beingIndex = 0;
        int endIndex = index + 2;
        boolean hasChars = true;

        if (length > 1 && length % 2 == 0) {
            do {

                index++;
                subString = auxInput.substring(beingIndex, endIndex);
                if (symbols.contains(subString)) {
                    auxInput = auxInput.replace(subString, "");
                    length = auxInput.length();
                    index = 0;
                }
                beingIndex = index;
                endIndex = index + 2;
                hasChars = endIndex <= length;

            } while (hasChars);
        }

        System.out.println(String.format("Resultado: \n > La entrada %s es: %s", input, length == 0));

    }
}
