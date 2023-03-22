package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String words) {
        if (words.length() == 0) {
            return new HashMap<>();
        }

        String[] wordList = words.split(" ");
        Map<String, Integer> dict = new HashMap<>();

        for (String word : wordList) {
            if (dict.containsKey(word)) {
                dict.put(word, (dict.get(word) + 1));
            } else {
                dict.put(word, 1);
            }
        }

        return dict;
    }

    public static String toString(Map<String, Integer> dict) {
        if (dict.isEmpty()) {
            return "{}";
        }

        Set<String> keys = dict.keySet();
        StringBuilder result = new StringBuilder("{\n");

        for (String key : keys) {
            result.append("  " + key + ": " + dict.get(key) + "\n");
        }

        result.append("}");

        System.out.println(result.toString());

        return result.toString();
    }
}
//END
