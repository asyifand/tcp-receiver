package com.example.tcpserver;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcpServerApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TcpServerApplication.class, args);

        try (Socket socket = new Socket("localhost", 8055)) {
            socket.setSoTimeout(5000); // set a timeout of 5 seconds
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println("you get the data from sender");
        }
    }

}
