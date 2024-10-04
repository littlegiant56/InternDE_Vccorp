package services;

import models.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalFarm {
    private List<Animal> animals;

    public AnimalFarm() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " has been added to the farm.");
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
        System.out.println(animal.getName() + " has been removed from the farm.");
    }

    public void showAllAnimals() {
        System.out.println("Animals in the farm:");
        for (Animal animal : animals) {
            System.out.println("- " + animal.getName());
        }
    }
}
