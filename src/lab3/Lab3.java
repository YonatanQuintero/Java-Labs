package lab3;

import java.util.Map;

/**
 * Dado un gran conjunto de palabras (más de 1 millón, por ejemplo) y un prefijo,
 * se debe encontrar el conjunto de palabras que pueden ser propuestas de autocompletado.
 * Dicho de otro modo, encontrar todas las palabras que comparten el prefijo dado.
 */
public class Lab3 {

    private final static String text = "Until recently, the prevailing view assumed lorem ipsum was born as a nonsense text. “It's not Latin, though it looks like it, and it actually says nothing,” Before & After magazine answered a curious reader, “Its ‘words’ loosely approximate the frequency with which letters occur in English, which is why at a glance it looks pretty real.”";
    private final static String prefix = "LO";

    public static void main(String args[]) {
        final TextSearch textSearch = new TextSearch(text, prefix);
        final Map<String, Integer> result = textSearch.search();
        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(String.format("%s (%s)", entry.getKey(), entry.getValue()));
        }

        final String highlightText = textSearch.highlightText();
        System.out.println(highlightText);

    }

}


