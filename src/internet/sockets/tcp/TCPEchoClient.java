package internet.sockets.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class TCPEchoClient {

    public static void main(String[] args) throws IOException {
        if (args.length < 2 || args.length > 3)
            throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

        String server = args[0];
        byte[] data = args[1].getBytes();

        int serverPort = args.length == 3 ? Integer.parseInt(args[2]) : 7;

        Socket socket = new Socket(server, serverPort);
        System.out.println("Connected to server ... sending echo string");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write(data);

        int totalBytesRcvd = 0;
        int bytesRcyd;

        while (totalBytesRcvd < data.length) {
            if ((bytesRcyd = in.read(data, totalBytesRcvd, data.length - totalBytesRcvd)) == -1) {
                throw new SocketException("Connection closed prematurely");
            }
            totalBytesRcvd += bytesRcyd;
        }

        System.out.println("Received : " + new String(data));

        socket.close();
    }
}
