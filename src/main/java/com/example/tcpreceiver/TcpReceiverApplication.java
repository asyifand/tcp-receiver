package com.example.tcpreceiver;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TcpReceiverApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TcpReceiverApplication.class, args);
        new Thread(new TcpReceiver(5678)).start();
    }
}
