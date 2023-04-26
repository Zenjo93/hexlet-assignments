package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public abstract class Tag {
    String tagName;
    Map<String, String> attributes;

    public Tag(String tagName,   Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = attributes;
    }

    public String toString() {
        return null;
    }

}
// END
