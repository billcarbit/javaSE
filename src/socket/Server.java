package socket;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server {

    static int time = 10;

    public static void main(String[] args) throws Exception {
        System.out.println("正在启动服务端");
        ServerSocket serverSocket = ServerSocketFactory.getDefault().createServerSocket();
        serverSocket.bind(new InetSocketAddress("192.168.0.7", 9090));
        System.out.println("服务端已启动");
        while (true) {
            System.out.println("等待接收...");
            Socket socket = serverSocket.accept();
            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();
            byte[] aa = new byte[2];

            while ((inputStream.read(aa)) != -1) {
                time--;
                System.out.println("time：" + time);
                if (time == 0) {
                    socket.shutdownOutput();
                    socket.close();
                    break;
                }
                Thread.sleep(1000);

                if(!socket.isClosed()){
                    outputStream.write(aa);
                    System.out.println("服务端接收到数据：" + new String(aa));
                }

            }


        }
    }
}
