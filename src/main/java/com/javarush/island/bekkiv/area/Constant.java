package com.javarush.island.bekkiv.area;

public interface Constant {
    float ANIMAL_HUNGRY = 0.95F;
    float WEIGHT_LOSS = 0.85F;//default 0.99975F
    float MIN_WEIGHT_REMOVAL_GAME = 0.5F;
    int PROBABILITY_REPRODUCTION = 99;//разобраться! Почему-то работает наоборот
    int GAME_CYCLE = 1;
    int PROBABILITY_MOTION = 50;
    long TIME_CYCLE_GROW_PLANTS = 1000;
}
