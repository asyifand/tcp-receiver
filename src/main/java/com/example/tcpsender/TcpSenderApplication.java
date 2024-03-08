package com.example.tcpsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

@SpringBootApplication
public class TcpSenderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TcpSenderApplication.class, args);

        try (Socket socket = new Socket("localhost", 8047)) {
            socket.setSoTimeout(5000); // set a timeout of 5 seconds
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("you get the data from sender");
        }
    }

}