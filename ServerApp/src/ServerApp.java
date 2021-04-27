import java.io.IOException;

public class ServerApp {

    public static void main(String[] args) {
        StartServer startServer = null;
        try {
            System.out.println("Сервер запущен на порту 8189. Ожидаем подключение клиента...");
            startServer = new StartServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (startServer != null) {
            startServer.serverInitialize();
        }
    }


}

