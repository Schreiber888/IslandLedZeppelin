package com.javarush.island.bekkiv.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface OrganismsAnnotation {
    float weightKg(); //
    int amountAnimalCell();
    float amountEat();
    int speed();
}
