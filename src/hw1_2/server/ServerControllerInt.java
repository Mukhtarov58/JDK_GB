package hw1_2.server;

import hw1_2.client.ClientGUI;

public interface ServerControllerInt {
    void startServer();
    void stopServer();
    boolean connectUser(ClientGUI clientGUI);
    void disconnectUser(ClientGUI clientGUI);
    void message(String text);
    String getLog();
}
