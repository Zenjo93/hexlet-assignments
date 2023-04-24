package exercise.connections;

// BEGIN
public class Disconnected implements Connection {

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public String connect() {
        return "true";
    }

    @Override
    public String disconnect() {
        return "Error";
    }

    @Override
    public String write(String data) {
       return "Error";

    }
}
// END
