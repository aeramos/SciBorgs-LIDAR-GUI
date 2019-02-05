package api;

import java.io.IOException;

public class Test {
    private static Client client;

    public static void main(String... args) {
        try {
            client = new Client();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            client.sendPoints(new Point[]{new Point(5, 4), new Point(0, 0)});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
