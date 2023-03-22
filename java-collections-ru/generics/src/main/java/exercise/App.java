package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        for (var book : books) {
            if ((book.get("author") == where.get("author")) && (book.get("year") == where.get("year"))) {
                if (where.containsKey("title")) {
                    if (book.get("title") == where.get("title")) {
                        result.add(book);
                    }
                } else {
                    result.add(book);
                }
            }

        }

        return result;

    }
}
//END
