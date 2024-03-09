package hw1_2.server;

public interface Repository {
    String readLog();
    void saveInLog(String text);
}
