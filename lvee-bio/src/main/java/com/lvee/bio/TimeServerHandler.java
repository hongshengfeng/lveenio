package com.lvee.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author lveeJava
 * @date 2020.05.25
 * @version 1.0.1
 */
public class TimeServerHandler implements Runnable{

    private Socket socket;

    TimeServerHandler(Socket socket){
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader in = null;
            PrintWriter out = null;
            try {
                in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
                out = new PrintWriter(this.socket.getOutputStream(), true);
                String currentTime = null;
                String body = null;
                while (true){
                    body = in.readLine();
                    if(body == null){
                        break;
                    }
                    System.out.println("receive body : " + body);

                }
            }finally {
                if(in != null){
                    in.close();
                }
                if(out != null){
                    out.close();
                }
                if(this.socket != null){
                    this.socket.close();
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
