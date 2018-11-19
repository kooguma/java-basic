package internet.sockets.tcp;

import com.sun.xml.internal.ws.addressing.WsaTubeHelperImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPEchoServer {

    private static final int BUFSIZE = 32;

    public static void main(String[] args) throws IOException {

        if (args.length != 1)
            throw new IllegalArgumentException("Parameter: <Port>");

        int serverPort = Integer.parseInt(args[0]);

        ServerSocket serverSocket = new ServerSocket(serverPort);

        int recvMsgSize;
        byte[] receiveBuf = new byte[BUFSIZE];

        while (true) {
            Socket clntSock = serverSocket.accept();

            SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
            System.out.println("Hadling client at " + clientAddress);

            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();

            while ((recvMsgSize = in.read(receiveBuf)) != -1) {
                out.write(receiveBuf, 0, recvMsgSize);
            }

            clntSock.close();
        }
    }
}
