package com.example.auth;

import io.micronaut.runtime.Micronaut;

public class Application {
    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();//this will be HashMap.
        dotenv.entries().forEach(entry ->
                System.setProperty(entry.getKey(), entry.getValue())
        );
        Micronaut.run(Application.class, args);
    }
}
