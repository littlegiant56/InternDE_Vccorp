package models;

import interfaces.Soundable;
import interfaces.Moveable;
import interfaces.Feedable;

public class Dog extends Animal implements Soundable, Moveable, Feedable {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("Dog barks");
    }

    @Override
    public void move() {
        System.out.println("Dog runs");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating bones");
    }
}
