package ru.lesson.lessons;

/**
 * Created by jur on 04.01.2019.
 */
public class Animal implements Pet {

    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal(){}

    private String name;


    public Animal(final String name) throws PetException {
        if (name == null || name.equals("") || name.length() < 2) {
            throw new PetException("Animal's name must be >1");
        }
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println(
                String.format("%s say : %s", this.name, "beep")
        );
    }

    private boolean isHangry() {
        return true;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        return name != null ? name.equals(animal.name) : animal.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
