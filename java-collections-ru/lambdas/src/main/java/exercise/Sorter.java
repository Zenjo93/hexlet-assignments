package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        return users.stream()
                .filter(user -> user.get("gender").equals("male"))
                .sorted((user1, user2) -> {
                    LocalDate user1Date = LocalDate.parse(user1.get("birthday"));
                    LocalDate user2Date = LocalDate.parse(user2.get("birthday"));
                    return user1Date.compareTo(user2Date);
                })
                .map(user -> user.get("name"))
                .collect(Collectors.toList());
    }
}
// END
