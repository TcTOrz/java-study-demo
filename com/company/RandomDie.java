package com.company;

import java.util.Random;

public class RandomDie {
    public int sides;
    private Random generator;
    public RandomDie(int s) {
        sides = s;
        generator = new Random();
    }
    public int cast() {
        return 1+generator.nextInt(sides);
    }
}
