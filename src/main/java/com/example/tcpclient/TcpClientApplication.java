package com.example.tcpclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class TcpClientApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TcpClientApplication.class, args);

        try (ServerSocket serverSocket = new ServerSocket(8055)) {
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String data = reader.readLine();
                System.out.println("Received data: " + data);
            }
        }
    }

}