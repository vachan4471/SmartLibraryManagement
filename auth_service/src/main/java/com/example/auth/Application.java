package com.example.auth;

import io.github.cdimascio.dotenv.Dotenv;
import io.micronaut.runtime.Micronaut;

import java.nio.file.Paths;

public class Application {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().directory(Paths.get("../").toAbsolutePath().toString())
                .load();//this will be HashMap.
        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );
        Micronaut.run(Application.class, args);
    }
}
