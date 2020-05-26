package com.lvee.bio.cli;

import java.io.*;
import java.net.Socket;

/**
 * @author lveeJava
 * @date 2020.05.25
 * @version 1.0.1
 */
public class TimeClient {

    public static void main(String[] args) throws IOException {
        if(args != null && args.length > 0){
            try {
                PORT = Integer.valueOf(args[0]);
            }catch (Exception e){

            }
        }
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket(IP, PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello World, lveeJava !");
            System.out.println("The TimeCli Send Success");
            String resp = in.readLine();
            System.out.println("NOW is : " + resp);
        }catch (Exception e){
            if(socket != null){
                socket.close();
            }
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        }
    }

    public static int PORT = 8080;
    public static String IP = "127.0.0.1";
}
