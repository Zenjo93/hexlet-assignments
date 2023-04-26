package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String tagBody;
    List<Tag> singleTagList = new ArrayList<>();

    public PairedTag(String tagName, Map<String, String> attributes, String tagBody, List<Tag> singleTagList) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.singleTagList.addAll(singleTagList);
    }

    @Override
    public String toString() {
        StringBuilder fullTag = new StringBuilder("<");
        fullTag.append(tagName);

        if (attributes.size() == 0) {
            return fullTag.append(">").append("</").append(tagName).append(">").toString();
        }

        String bodyAttr = attributes.keySet().stream()
                .map(key -> key + "=" + "\"" + attributes.get(key) + "\"")
                .collect(Collectors.joining(" ", " ", ""));

        fullTag.append(bodyAttr).append(">").append(tagBody);


        String children = singleTagList.stream()
                .map(Tag::toString).collect(Collectors.joining()).trim();

        fullTag.append(children).append("</").append(tagName).append(">");

        return fullTag.toString();

    }
}
// END
