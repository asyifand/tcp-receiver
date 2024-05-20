package com.example.tcpreceiver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpReceiver implements  Runnable {
    /** port */
    private int port;

    public TcpReceiver(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String data = reader.readLine();
                System.out.println("Received data: " + data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
