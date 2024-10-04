package models;

import interfaces.Soundable;
import interfaces.Moveable;
import interfaces.Feedable;

public class Cat extends Animal implements Soundable, Moveable, Feedable {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        System.out.println("Cat meows");
    }

    @Override
    public void move() {
        System.out.println("Cat jumps");
    }

    @Override
    public void eat() {
        System.out.println("Cat is eating fish");
    }
}
