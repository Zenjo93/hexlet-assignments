package exercise;
import exercise.connections.Connected;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
class TcpConnection {
    Connection state;
    String address;
    int port;

    public TcpConnection(String adress, int port) {
        this.address = adress;
        this.port = port;
        state = new Disconnected();
    }

    public void connect() {
        state = new Connected();
        System.out.println(state.connect());
    }

    public void disconnect() {
        state = new Disconnected();
        System.out.println(state.disconnect());
    }

    public String getCurrentState() {
        return state.getCurrentState();
    }

    public void write(String data) {
        String message = state.write(data);
        System.out.println(message);

    }




}
// END
