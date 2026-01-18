package com.javarush.island.bekkiv;


import com.javarush.island.bekkiv.game.Game;

import java.util.concurrent.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Runner {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        FactoryOrganisms factoryOrganisms = new FactoryOrganisms();
        try {
            factoryOrganisms.makeAnimals();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(factoryOrganisms, 0, 1000, TimeUnit.SECONDS);

    }
}