package com.javarush.island.bekkiv.organisms;


import com.javarush.island.bekkiv.annotation.OrganismsAnnotation;
import com.javarush.island.bekkiv.organisms.animals.capabilities.ReproducibleAnimals;


public abstract class Organisms implements Cloneable {

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
