package com.dimkas71.twitter.demo;

public class FakeConnection {
    public void openConnection() {
        System.out.println("Connected");
    }

    public void send(String message) {
        System.out.println(String.format("Message: %s", message));
    }
}
