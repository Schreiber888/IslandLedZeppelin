package com.javarush.island.bekkiv.organisms.animals.capabilities;
@FunctionalInterface
public interface Moveable {
    int[][] move(int xCell, int yCell);
}
