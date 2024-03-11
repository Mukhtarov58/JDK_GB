package hw1_2.server;

import hw1_2.client.ClientController;

import java.util.ArrayList;
import java.util.List;

public class ServerController implements ServerControllerInt {
    private List<ClientController> clientControllerList;
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
        this.clientControllerList = new ArrayList<>();
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
            while (!clientControllerList.isEmpty()) {
                disconnectUser(clientControllerList.get(clientControllerList.size() - 1));
            }
            serverView.appendLog("Сервер остановлен!");
        }
    }



    @Override
    public boolean connectUser(ClientController clientController){
        if (!work){
            return false;
        }
        clientControllerList.add(clientController);
        return true;
    }


    @Override
    public void disconnectUser(ClientController clientController) {
        clientControllerList.remove(clientController);
        if (clientController != null) {
            clientController.disconnectedFromServer();
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
        for (ClientController clientController : clientControllerList){
            clientController.answerFromServer(text);
        }
    }

}