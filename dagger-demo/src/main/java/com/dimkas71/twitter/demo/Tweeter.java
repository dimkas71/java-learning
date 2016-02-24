package com.dimkas71.twitter.demo;

public class Tweeter {
    public void tweet(String message) {
        TwitterApi api = new TwitterApi();
        api.postTweet(message);
    }
}
