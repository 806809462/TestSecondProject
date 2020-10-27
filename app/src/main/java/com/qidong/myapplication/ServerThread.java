package com.qidong.myapplication;

public class ServerThread extends Thread {
    public volatile boolean exit = false;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (currentThread().isInterrupted()) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ServerThread serverThread = new ServerThread();
        serverThread.start();
        serverThread.exit = true;
        serverThread.interrupt();

    }
}
