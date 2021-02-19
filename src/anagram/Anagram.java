package anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    public static void main(String args[]) {

        System.out.println(String.format("Expected: %s, Result :%s", true, checkAnagram("act robed alt", "tal bored cat")));
        System.out.println(String.format("Expected: %s, Result :%s", false, checkAnagram("aa bb", "ab ab")));
        System.out.println(String.format("Expected: %s, Result :%s", false, checkAnagram("a", "b")));
        System.out.println(String.format("Expected: %s, Result :%s", false, checkAnagram("ygsimuzpdopaceydpz m", "zmpyu pamdzyegsdciop")));

    }

    public static boolean checkAnagram(String s, String t) {
        List<String> listS = new ArrayList<>(Arrays.asList(s.split(" ")));
        List<String> listT = new ArrayList<>(Arrays.asList(t.split(" ")));

        //if (listS.size() != listT.size()) return;

        for (int i = 0; i < listS.size(); i++) {
            String wordS = listS.get(i);
            for (int j = 0; j < listT.size(); j++) {
                String wordT = listT.get(j);
                if (areAnagram(wordS, wordT)) {
                    listT.remove(wordT);
                }
            }
        }
        return listT.isEmpty();
    }

    public static boolean areAnagram(String s, String t) {
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        if (charS.length != charT.length) return false;

        Arrays.sort(charS);
        Arrays.sort(charT);

        return Arrays.equals(charS, charT);

    }
}
