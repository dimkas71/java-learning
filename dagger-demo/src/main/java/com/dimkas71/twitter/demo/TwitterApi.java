package com.dimkas71.twitter.demo;


public class TwitterApi {

    public void postTweet(String message) {
        FakeConnection connection = new FakeConnection();

        connection.openConnection();
        connection.send(message);

    }
}
