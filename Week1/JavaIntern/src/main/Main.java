package main;

import models.Dog;
import models.Cat;
import services.AnimalPrinter;
import services.AnimalManager;
import services.AnimalFarm;

public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog("Buddy", 3);
        Cat cat = new Cat("Whiskers", 2);

        AnimalPrinter printer = new AnimalPrinter();
        printer.printAnimalInfo(dog);
        printer.printAnimalInfo(cat);

        AnimalManager dogManager = new AnimalManager(dog);
        AnimalManager catManager = new AnimalManager(cat);
        dogManager.makeSound();
        catManager.makeSound();

        AnimalFarm farm = new AnimalFarm();
        farm.addAnimal(dog);
        farm.addAnimal(cat);
        farm.showAllAnimals();

        dog.eat();
        cat.eat();

        System.out.println(dog.getName() + " has " + dog.calculateRemainingYears() + " years remaining.");
        System.out.println(cat.getName() + " has " + cat.calculateRemainingYears() + " years remaining.");

        dog.move(); // Dog runs
        cat.move(); // Cat jumps
    }
}
