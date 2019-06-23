package ru.lesson.lessons;

/**
 * Created by jur on 04.01.2019.
 */
public class Dog extends Animal implements Pet {
    private Pet pet;

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Dog(){}

    public Dog(final Pet pet) {
        this.pet = pet;
    }

    @Override
    public void makeSound() {
        System.out.println(String.format("%5s , %5s", "Gav", "Gav"));
    }

    @Override
    public String getName(){
        return this.pet.getName();
    }

    @Override
    public void setName(String newName) {
        this.pet.setName(newName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dog dog = (Dog) o;

        return pet != null ? pet.equals(dog.pet) : dog.pet == null;
    }

    @Override
    public int hashCode() {
        return pet != null ? pet.hashCode() : 0;
    }
}
