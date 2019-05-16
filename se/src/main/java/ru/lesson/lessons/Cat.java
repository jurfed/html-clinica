package ru.lesson.lessons;

/**
 * Created by jur on 04.01.2019.
 */
public class Cat extends Animal {

    public Cat(final String name) throws PetException {
        super(name);
    }

    public void catchMouse() {

    }

    @Override
    public void makeSound(){
        System.out.println(
                String.format("%s say : %s", this.getName(), "beep")
        );
    }


}
