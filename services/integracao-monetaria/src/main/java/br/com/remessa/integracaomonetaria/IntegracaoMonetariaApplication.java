package br.com.remessa.integracaomonetaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.remessa.rabbitmqutil", "br.com.remessa.portalbancario",})
public class IntegracaoMonetariaApplication {
    public static void main(String[] args) {
        SpringApplication.run(IntegracaoMonetariaApplication.class, args);
    }

}