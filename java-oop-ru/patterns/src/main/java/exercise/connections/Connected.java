package exercise.connections;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Connected implements Connection {

    List<String> bd = new ArrayList<>();

    @Override
    public String getCurrentState() {
        return "connected";
    }

    @Override
    public String connect() {
        return "Error";
    }

    @Override
    public String disconnect() {
        return "true";
    }

    @Override
    public String write(String data) {
        bd.add(data);
        return "true";
    }
}
// END
