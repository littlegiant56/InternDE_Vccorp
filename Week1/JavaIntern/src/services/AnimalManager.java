package services;

import interfaces.Soundable;

public class AnimalManager {
    private Soundable soundableAnimal;

    public AnimalManager(Soundable soundableAnimal) {
        this.soundableAnimal = soundableAnimal;
    }

    public void makeSound() {
        soundableAnimal.sound();
    }
}
