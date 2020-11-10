package lab3;

import java.util.HashMap;
import java.util.Map;

public class TextSearch {

    private String text;
    private String prefix;
    private Map<String, Integer> result;

    public TextSearch(String text, String prefix) {
        this.text = text;
        this.prefix = prefix.toLowerCase();
        this.result = new HashMap<>();
    }

    /**
     * @return Map with the times that word is found in the text, using prefix
     */
    public Map<String, Integer> search() {
        normalizeText();
        for (String character : split()) {
            if (character.toLowerCase().startsWith(prefix)) {
                addOrUpdated(character);
            }
        }
        return result;
    }

    /**
     * @return highlight text with prefix in brackets
     */
    public String highlightText() {
        final StringBuilder builder = new StringBuilder();
        final String split[] = split();

        for (int i = 0; i < split.length; i++) {
            if (i > 0) builder.append(" ");
            String character = split[i];
            if (character.toLowerCase().startsWith(prefix)) {
                character = highlightCharacter(character);
            }
            builder.append(character);
        }
        return builder.toString();
    }

    private String highlightCharacter(String character) {
        String auxCharacter;
        StringBuilder auxBuilder;
        auxCharacter = character.substring(0, prefix.length());
        auxBuilder = new StringBuilder();
        auxBuilder.append("[");
        auxBuilder.append(auxCharacter);
        auxBuilder.append("]");
        auxCharacter = character.substring(prefix.length(), character.length());

        if (auxCharacter != null) auxBuilder.append(auxCharacter);

        character = auxBuilder.toString();
        return character;
    }

    private void normalizeText() {
        text = text.replaceAll("[^A-Za-z0-9\\s]", "");
    }

    private void addOrUpdated(String character) {
        Integer value = 1;
        if (result.containsKey(character)) {
            value = result.get(character) + 1;
        }
        result.put(character, value);
    }

    private String[] split() {
        return text.split("\\s");
    }
}