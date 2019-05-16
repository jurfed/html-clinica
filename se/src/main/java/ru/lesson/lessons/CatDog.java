package ru.lesson.lessons;

/**
 * Created by jur on 04.01.2019.
 */
public class CatDog implements Pet{
    private final Cat cat;
    private final Dog dog;

    public CatDog(Cat cat, Dog dog) {
        this.cat = cat;
        this.dog = dog;
    }

    @Override
    public void makeSound() {
        this.cat.makeSound();
        this.dog.makeSound();
    }

    @Override
    public String getName() {
        return String.format("%s %s",this.cat.getName(), this.dog.getName());
    }

    @Override
    public void setName(String newName) {
        this.cat.setName(newName);
        this.dog.setName("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CatDog catDog = (CatDog) o;

        if (cat != null ? !cat.equals(catDog.cat) : catDog.cat != null) return false;
        return dog != null ? dog.equals(catDog.dog) : catDog.dog == null;
    }

    @Override
    public int hashCode() {
        int result = cat != null ? cat.hashCode() : 0;
        result = 31 * result + (dog != null ? dog.hashCode() : 0);
        return result;
    }
}
