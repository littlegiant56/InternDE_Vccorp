package models;

public class Animal {
    private String name;
    private int age;
    private int maxLifespan;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.maxLifespan = 15;
    }

    public Animal(String name, int age, int maxLifespan) {
        this.name = name;
        this.age = age;
        this.maxLifespan = maxLifespan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMaxLifespan() {
        return maxLifespan;
    }

    public void setMaxLifespan(int maxLifespan) {
        this.maxLifespan = maxLifespan;
    }

    public int calculateRemainingYears() {
        return maxLifespan - age;
    }

    public void sound() {
        System.out.println("This animal makes a sound");
    }
}
