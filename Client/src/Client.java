import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private DataInputStream in;
    private DataOutputStream out;

    public void initialize() {
        try {
            Socket socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            Thread dataThread = new Thread(() -> {
                try {
                    while (true) {
                        String msg = in.readUTF();
                        System.out.println(msg);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            dataThread.start();
            System.out.println("Начните общаться с сервером");
            while (true) {
                sendMsg();
            }

        } catch (IOException e) {
            throw new RuntimeException("Unable to connect to server [localhost: 8189]");
        }
    }

    public void sendMsg() {
        Scanner scanner = new Scanner(System.in);
        String msg = scanner.nextLine();
        try {
            out.writeUTF(msg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

