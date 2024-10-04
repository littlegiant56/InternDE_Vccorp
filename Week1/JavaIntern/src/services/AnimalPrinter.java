package services;

import models.Animal;

public class AnimalPrinter {
    public void printAnimalInfo(Animal animal) {
        System.out.println("Animal's name: " + animal.getName());
        System.out.println("Animal's age: " + animal.getAge());
    }
}
