package ru.lesson.lessons;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jur on 04.01.2019.
 */
public class ClinicRunner {

    /**
     * создаем объект клюиники
     */
    private static Clinic clinic;

    public static void main(String[] args) throws PetException, CreateClientException {
        ClinicRunner clinicRunner = new ClinicRunner();
        clinicRunner.initClinic();
        UserInterface userInterface = new UserInterface(clinic);
        userInterface.mainCircle();
    }

    /**
     * инициализируем начальных клиентов
     * @throws PetException
     * @throws CreateClientException
     */
    private void initClinic() throws PetException, CreateClientException {
        Cat cat1 = new Cat("Kisy");
        Client client1 = new Client("Robby", cat1);

        Dog dog = new Dog(new Animal("Bobik"));
        Client client2 = new Client("Bob", dog);

        CatDog catDog = new CatDog(new Cat("Koty"), new Dog(new Animal("pusy")));
        Client client3 = new Client("Piter", catDog);

        clinic = new Clinic();
        clinic.addClient(client1);
        clinic.addClient(client2);
        clinic.addClient(client3);
    }
}

/**
 * пользовательский интерфейс ввода
 */
class UserInterface {
    private Clinic clinic;
    private final Scanner reader = new Scanner(System.in);

    public UserInterface(Clinic clinic) {
        this.clinic = clinic;
    }

    void mainCircle() throws PetException {
        String action;
        while (true) {
            System.out.printf("chose action %n 1) add client %n 2) find by client name %n 3) find by pet name  %n 4) edit client name %n 5) edit pet name %n 6) delete client %n 7) exit %n");

            action = reader.next();
            switch (action) {
                case "1":
                    addClient();
                    break;
                case "2":
                    findByClientName();
                    break;
                case "3":
                    findByPetName();
                    break;
                case "4":
                    String oldName;
                    String newName;
                    System.out.println("Enter client old name");
                    oldName = reader.next();
                    System.out.println("Enter client new name");
                    newName = reader.next();
                    editClientName(oldName, newName);
                    break;
                case "5":
                    String oldPetName;
                    String newPetName;
                    System.out.println("Enter Pet old name");
                    oldPetName = reader.next();
                    System.out.println("Enter Client new name");
                    newPetName = reader.next();
                    editPetName(oldPetName, newPetName);
                    break;
                case "6":
                    System.out.println("enter client name for delete");
                    String deleteClient = reader.next();
                    deleteClient(deleteClient);
                    break;
                case "7":
                    System.exit(0);
                    break;
            }
        }
    }


    private void addClient() {
        String clientName;
        String petType;
        String petName;
        System.out.println("Enter client name");
        clientName = reader.next();
        System.out.println("enter type of your pet: 1) Cat %n 2) Dog %n 3) DogCat");
        petType = reader.next();
        Pet pet = null;
        switch (petType) {
            case "1":
                System.out.println("Enter pet name");
                petName = reader.next();
                try {
                    pet = new Cat(petName);
                } catch (PetException e) {
                    System.err.println("error was accured:  " + e.getMessage());
                }
                break;
            case "2":
                System.out.println("Enter pet name");
                petName = reader.next();
                try {
                    pet = new Dog(new Animal(petName));
                } catch (PetException e) {
                    System.err.println(e.getMessage());
                }
                break;
            case "3":
                System.out.println("Enter first pet name");
                String first = reader.next();
                System.out.println("Enter second pet name");
                String second = reader.next();
                try {
                    pet = new CatDog(new Cat(first), new Dog(new Animal(second)));
                } catch (PetException e) {
                    System.out.println(e.getMessage());
                }
                break;
        }
        Client client = null;
        try {
            client = new Client(clientName, pet);
        } catch (CreateClientException e) {
            System.out.println(e.getMessage());
        }
        clinic.addClient(client);
    }

    private void findByClientName() {
        System.out.println("Enter Client name");
        String clientName = reader.next();
        Client client = clinic.findClientByClientName(clientName);
        System.out.println(client);
    }

    private void findByPetName() {
        System.out.println("Enter Pet name");
        String petName = reader.next();
        Client client = clinic.findClientByPetName(petName);
        System.out.println(client);
    }

    private void editClientName(String firstName, String lastName) throws PetException {
        clinic.editClientName(firstName, lastName);

        System.out.println("new Client name: ");
        Client client = clinic.findClientByClientName(lastName);
        System.out.println(client);
    }

    private void editPetName(String firstName, String lastName) {
        clinic.editPetName(firstName, lastName);

        System.out.println("new pet name: ");
//        Client[] clients = clinic.findClientByPetName(lastName);
//        Arrays.stream(clients).forEach(client -> System.out.println(client));
    }

    private void deleteClient(String clientName) {
        clinic.deleteClient(clientName);
        clinic.printClients();
    }
}