package com.lvee.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author lveeJava
 * @date 2020.05.25
 * @version 1.0.1
 */
public class TimeServer {

    public static int PORT = 8080;

    public static void main(String[] args) throws IOException {
        if(args != null && args.length > 0){
            try {
                PORT = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("The time server is start in port : " + PORT);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }finally {
            if(server != null){
                System.out.println("The server is close");
                server.close();
            }
        }
    }
}
