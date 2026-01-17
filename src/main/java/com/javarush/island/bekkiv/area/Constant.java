package com.javarush.island.bekkiv.area;

public interface Constant {
    float COEFFICIENT_GAIN_WEIGHT = 0.2f; //the animal increases its weight according to this coefficient
    float ANIMAL_HUNGRY = 0.95F;
    float WEIGHT_LOSS = 0.95F;//default 0.99975F
    float MIN_WEIGHT_REMOVAL_GAME = 0.3F;
    int PROBABILITY_REPRODUCTION = 98;
    int GAME_CYCLE = 30;
    int PROBABILITY_MOTION = 50;
}
