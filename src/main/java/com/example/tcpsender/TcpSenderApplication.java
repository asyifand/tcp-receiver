package com.example.tcpsender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class TcpSenderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TcpSenderApplication.class, args);
        new Thread(new TcpSender("localhost", 5678)).start();
    }

}