package hw1_2.server;

public interface ServerView {
    void appendLog(String text);
    void setVisible(boolean visible);
    void setServerController(ServerController serverController);

}