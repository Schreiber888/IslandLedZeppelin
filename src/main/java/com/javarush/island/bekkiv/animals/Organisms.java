package com.javarush.island.bekkiv.animals;

public class Organisms implements Cloneable {
    public int age;

    @Override
    public Organisms clone() {
        try {
            Organisms clone = (Organisms) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
