package br.com.remessa.transferenciabancaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.remessa.rabbitmqutil", "br.com.remessa.portalbancario",})
@EnableFeignClients
public class TransferenciaBancariaApplication {
    public static void main(String[] args) {
        SpringApplication.run(TransferenciaBancariaApplication.class, args);
    }

}