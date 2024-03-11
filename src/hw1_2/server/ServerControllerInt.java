package hw1_2.server;

import hw1_2.client.ClientController;

public interface ServerControllerInt {
    void startServer();
    void stopServer();

    boolean connectUser(ClientController clientController);

    void disconnectUser(ClientController clientController);

    void message(String text);
    String getLog();
}
