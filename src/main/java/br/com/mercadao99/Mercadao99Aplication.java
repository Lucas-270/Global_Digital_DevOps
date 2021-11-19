package br.com.mercadao99;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Mercadao99Aplication {

    public static void main(String[] args) {
        SpringApplication.run(Mercadao99Aplication.class, args);
    }
}
