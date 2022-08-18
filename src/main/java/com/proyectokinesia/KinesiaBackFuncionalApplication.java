package com.proyectokinesia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.proyectokinesia" })
public class KinesiaBackFuncionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinesiaBackFuncionalApplication.class, args);
    }

}
