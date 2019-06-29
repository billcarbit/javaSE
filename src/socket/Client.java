package socket;

import javax.net.SocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = SocketFactory.getDefault().createSocket();
        socket.connect(new InetSocketAddress("192.168.0.7", 9090));
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        while (true) {
            byte[] bb = new byte[2];
            bb[0] = '1';
            bb[1] = '2';
            outputStream.write(bb);
            byte[] cc = new byte[2];
            int result = inputStream.read(cc);
            if (result == -1) {
                System.out.println("stream is at the end of the file");
                break;
            }
            System.out.println("客户端接收到数据：" + new String(cc));

        }
    }
}
