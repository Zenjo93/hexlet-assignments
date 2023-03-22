package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
// BEGIN
class App {
    public static boolean scrabble(String chars, String word) {
        String normalizeWor = word.toLowerCase();
        List<String> wordChars = new ArrayList<>(Arrays.asList(normalizeWor.split("")));
        List<String> charList = new ArrayList<>(Arrays.asList(chars.split("")));

        int length = 0;

        for (var wordChar : wordChars) {
            if (charList.contains(wordChar)) {
                System.out.println(wordChar);
                length += 1;
                charList.remove(wordChar);
            }
        }
        return word.length() == length;
    }
}

