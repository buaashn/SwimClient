package model.connect;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPConnect {
    public void sendText(String str){
        try {
            //创建Socket对象
            Socket socket=new Socket("localhost",8888);

            //根据输入输出流和服务端连接
            OutputStream outputStream=socket.getOutputStream();//获取一个输出流，向服务端发送信息
            PrintWriter printWriter=new PrintWriter(outputStream);//将输出流包装成打印流
            printWriter.print(str);
            printWriter.flush();
            socket.shutdownOutput();//关闭输出流

            printWriter.close();
            outputStream.close();
            socket.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
