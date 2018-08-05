package com.udacity.gradle.jokes;

import java.util.Random;

public class Joker {
    private String[] jokes = {"This is totally a funny joke", "Another totally a funny joke", "Super funny joke"};
    public String getJoke() {
        Random rand = new Random();
        return jokes[rand.nextInt(3)];
    }
}
