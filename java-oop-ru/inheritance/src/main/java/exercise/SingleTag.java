package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class SingleTag extends Tag {

    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName, attributes);
    }

    @Override
    public String toString() {
        if (attributes.size() == 0) {
            return "<" + tagName + ">";
        }

        String tagBody = attributes.keySet().stream()
                .map(key -> key + "=" + "\"" + attributes.get(key) + "\"")
                .collect(Collectors.joining(" ", " ", ""));

        return "<" + tagName + tagBody + ">";
    }
}
// END

/*
 String mapAsString = map.keySet().stream()
      .map(key -> key + "=" + map.get(key))
      .collect(Collectors.joining(", ", "{", "}"));
 */