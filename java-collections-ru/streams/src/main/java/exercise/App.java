package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        List domens = Arrays.asList("gmail.com", "yandex.ru", "hotmail.com");

        return (int)emails.stream().map(email -> {
            int index = email.indexOf("@");
            return email = email.substring(index + 1);
        }).filter(email -> domens.contains(email)).count();

    }
}
// END
