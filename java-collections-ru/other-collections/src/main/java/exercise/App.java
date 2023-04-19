package exercise;

import java.util.*;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> uniqueKeys = new TreeSet<>(data1.keySet());
        uniqueKeys.addAll(data2.keySet());

        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        for (String key : uniqueKeys) {
            if (!data1.containsKey(key)) {
                result.put(key, "added");

            } else if (!data2.containsKey(key)) {
                result.put(key, "deleted");

            } else if ((data1.get(key) == null) || !data1.get(key).equals(data2.get(key))) {
                result.put(key, "changed");

            } else {
                result.put(key, "unchanged");

            }
        }

    return result;
    }
}
//END
