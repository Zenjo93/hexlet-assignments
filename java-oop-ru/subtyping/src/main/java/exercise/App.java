package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> mapStorage = storage.toMap();

        for (Map.Entry<String, String> entry : mapStorage.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();

            storage.unset(key);
            storage.set(value, key);
        }
    }
}
// END
