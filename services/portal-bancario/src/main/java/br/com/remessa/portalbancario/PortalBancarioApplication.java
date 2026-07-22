package br.com.remessa.portalbancario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.remessa.rabbitmqutil", "br.com.remessa.portalbancario",})
public class PortalBancarioApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalBancarioApplication.class, args);
    }

}