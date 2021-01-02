import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lab5 {

    public static void main(String[] args) {
        System.out.println(solution2("aaBabcDaA"));
        System.out.println(solution2("Codility"));
        System.out.println(solution2("WeTestCodErs"));
    }

    public static String solution2(String s) {

        final String words[] = s.split("");
        int major = 0;
        for (int i = 0; i < words.length; i++) {
            String target = words[i];
            for (int j = i + 1; j < words.length; j++) {
                String word = words[j];
                if (target.equalsIgnoreCase(word)) {
                    if (Character.isLowerCase(target.charAt(0))) {
                        if (Character.isUpperCase(word.charAt(0))) {
                            int code = word.codePointAt(0);
                            if (code > major) {
                                major = code;
                            }
                        }
                    } else if (Character.isUpperCase(target.charAt(0))) {
                        if (Character.isLowerCase(word.charAt(0))) {
                            int code = word.codePointAt(0);
                            if (code > major) {
                                major = code;
                            }
                        }
                    }
                }
            }
        }
        if (major > 0) {
            return String.valueOf(Character.toChars(major));
        } else {
            return "NO";
        }
    }

    public static String solution(String S) {

        HashMap<String, Boolean> words = new HashMap<String, Boolean>();
        List<Integer> positions = new ArrayList();
        String split[] = S.split("");
        for (int i = 0; i < split.length; i++) {
            String c = split[i];
            if (words.containsKey(c.toLowerCase())) {
                boolean isLowerCase = words.get(c.toLowerCase());
                if (!(isLowerCase && Character.isLowerCase(c.charAt(0)))) {
                    positions.add(c.toUpperCase().codePointAt(0));
                }
            } else {
                words.put(c.toLowerCase(), Character.isLowerCase(c.charAt(0)));
            }
        }
        //System.out.println(positions);
        if (positions.size() > 0) {
            int result = 0;
            for (Integer word : positions) {
                if (word > result) {
                    result = word;
                }
            }
            //System.out.println(c);
            return Character.toString((char) result);
        } else {
            return "NO";
        }
    }
}
