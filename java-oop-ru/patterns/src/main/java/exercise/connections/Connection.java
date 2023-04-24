package exercise.connections;

public interface Connection {
    // BEGIN
    String getCurrentState();
    String connect();
    String disconnect();
    String write(String data);

    // END
}
