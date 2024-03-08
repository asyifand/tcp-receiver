package com.example.tcpreceiver;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcpReceiverApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TcpReceiverApplication.class, args);

        try (ServerSocket serverSocket = new ServerSocket(8047)) {
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String data = reader.readLine();
                System.out.println("Received data: " + data);
            }
        }
    }

}
