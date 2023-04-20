package exercise;

import java.util.*;
import java.util.stream.Collectors;


// BEGIN
public class App {

    public static String getForwardedVariables(String content) {

        String[] lines = content.split("\n");

        return Arrays.stream(lines)
                .filter(line -> line.startsWith("environment"))
                .map(line -> line.replaceAll("environment=", ""))
                .map(line -> line.replaceAll("\"", ""))
                .flatMap(line ->
                        Arrays.stream(line.split(","))
                                .filter(innerLine -> innerLine.startsWith("X_FORWARDED_"))
                                .map(filteredLine -> filteredLine.replaceAll("X_FORWARDED_", ""))).collect(Collectors.joining(","));

    }

}
//END
