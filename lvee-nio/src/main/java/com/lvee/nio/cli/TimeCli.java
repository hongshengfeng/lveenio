package com.lvee.nio.cli;

public class TimeCli {
    public static void main(String[] args) {
        int port = 8080;
        if(args != null && args.length > 0){
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }
        TimeCliHandler handler = new TimeCliHandler("127.0.0.1", port);
        new Thread(handler, "NIO-TimeCliHandler").start();
    }
}
