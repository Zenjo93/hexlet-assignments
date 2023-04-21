package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static List<String> buildApartmentsList(List<Home> apartments, int num) {
        List<String> appartmetnsList = apartments.stream()
                .sorted((aprt1, aprt2) -> aprt1.compareTo(aprt2))
                .map(Object::toString)
                .toList();


        if (num > appartmetnsList.size()) {
            return appartmetnsList;
        }

        return appartmetnsList.subList(0, num);


    }
}
// END
