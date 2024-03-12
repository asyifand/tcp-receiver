package com.example.tcpsender;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class TcpSender implements Runnable {

    private String ipAddress;
    private int port;

    public TcpSender(String ipAddress, int port) {
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    public void run() {
        String binaryData = "1010000000001000000000000000100100000011";

        try (Socket socket = new Socket(ipAddress, port)) {
            socket.setSoTimeout(5000); // set a timeout of 5 seconds
            OutputStream output = socket.getOutputStream();
            output.write(binaryData.getBytes(StandardCharsets.UTF_8));
            output.flush();
//            OutputStream output = socket.getOutputStream();
//            PrintWriter writer = new PrintWriter(output, true);
//            writer.println("you get the data from sender");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
