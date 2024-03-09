package hw1_2.server;

import hw1_2.client.ClientGUI;

import java.util.ArrayList;
import java.util.List;

public class ServerController implements ServerControllerInt {
    private List<ClientGUI> clientGUIList;
    private boolean work;

    private ServerView serverView;
    private Repository repository;


    public void setServerView(ServerView serverView) {
        this.serverView = serverView;
    }
    public void setRepository(Repository repository) {
        this.repository = repository;
    }



    public ServerController(ServerView serverView, Repository repository) {
        this.serverView = serverView;
        this.repository = repository;
        this.clientGUIList = new ArrayList<>();
    }

    @Override
    public void startServer() {
        if (work) {
            serverView.appendLog("Сервер уже был запущен");
        } else {
            work = true;
            serverView.appendLog("Сервер запущен!");
        }
    }

    @Override
    public void stopServer() {
        if (!work) {
            serverView.appendLog("Сервер уже был остановлен");
        } else {
            work = false;
            while (!clientGUIList.isEmpty()) {
                disconnectUser(clientGUIList.get(clientGUIList.size() - 1));
            }
            serverView.appendLog("Сервер остановлен!");
        }
    }

    @Override
    public boolean connectUser(ClientGUI clientGUI){
        if (!work){
            return false;
        }
        clientGUIList.add(clientGUI);
        return true;
    }

    @Override
    public void disconnectUser(ClientGUI clientGUI) {
        clientGUIList.remove(clientGUI);
        if (clientGUI != null) {
            clientGUI.disconnectedFromServer();
            serverView.appendLog("Пользователь отключен");
        }
    }

    @Override
    public void message(String text) {
        serverView.appendLog(text);
        answerAll(text);
        repository.saveInLog(text);
    }

    @Override
    public String getLog() {
        return repository.readLog();
    }


    private void answerAll(String text) {
        for (ClientGUI clientGUI : clientGUIList) {
            clientGUI.answer(text);
        }
    }

}