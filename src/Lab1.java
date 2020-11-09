import java.time.Duration;
import java.time.Instant;
import java.util.*;

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

    final static List<String> opens = new ArrayList<String>() {{
        add("(");
        add("[");
        add("{");
    }};

    final static HashMap<String, String> pairs = new HashMap<String, String>() {{
        put("[", "]");
        put("{", "}");
        put("(", ")");
    }};

    public static void main(String args[]) {
        final List<String> inputs = new LinkedList<String>() {{
            add("[()]{}{[({})[(})]()}");
            add("[(])");
            add("[()]{}{[({})()]()}");
            add("[()]{}{[({})[(})]()}");
        }};

        Instant start = Instant.now();
        inputs.forEach(input -> {
            validate(input);
            //System.out.println(String.format("Resultado: \n > La entrada %s es: %s", input, validate(input)));
        });
        Instant end = Instant.now();
        Duration interval = Duration.between(start, end);
        System.out.println("Validate time in seconds: " + interval.getNano());


        start = Instant.now();
        inputs.forEach(input -> {
            correctPairs(input);
        });
        end = Instant.now();
        interval = Duration.between(start, end);
        System.out.println("Correct pairs time in seconds: " + interval.getNano());
    }

    /**
     * Solution proposed by Betatech
     */
    private static boolean validate(String text) {
        final Stack<String> stack = new Stack<>();
        for (String character : text.split("")) {
            if (isOpen(character)) {
                stack.push(character);
            } else {
                String topChar = stack.pop();
                if (!closes(topChar, character)) {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }

    private static boolean closes(String characterA, String characterB) {
        return pairs.get(characterA).equals(characterB);
    }

    private static boolean isOpen(String character) {
        return opens.contains(character);
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

        //System.out.println(String.format("Resultado: \n > La entrada %s es: %s", input, length == 0));

    }
}
