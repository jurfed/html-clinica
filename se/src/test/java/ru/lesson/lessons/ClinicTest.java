package ru.lesson.lessons;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by jur on 06.01.2019.
 */
public class ClinicTest {


    @Test
    public void addClient() throws Exception {
        Client client = new Client("Bob", new Cat("Coty"));
        Clinic clinic = new Clinic();
        clinic.addClient(client);
        String clientsInfo = clinic.getClients();

        assertEquals(clientsInfo, "Client: Bob   Pet:Coty");
    }

    @Test(expected = PetException.class)
    public void createPetException() throws PetException {
        Pet pet = new Dog(new Animal(""));
    }

    @Test(expected = CreateClientException.class)
    public void addClientException() throws CreateClientException, PetException {
        Client client = new Client("", new Cat("Kity"));
    }

    @Test
    public void findClientByPetName() throws Exception {
        Client client = new Client("Bob", new Cat("Coty"));
        Clinic clinic = new Clinic();
        clinic.addClient(client);

        Client client1 = clinic.findClientByPetName("Coty");

        String clientsInfo = client1.getClient();

        assertEquals(clientsInfo, "Client: Bob   Pet:Coty");
    }

    @Test
    public void findClientByClientName() throws Exception {
        Client client = new Client("Bob", new Cat("Coty"));
        Clinic clinic = new Clinic();
        clinic.addClient(client);

        Client client1 = clinic.findClientByClientName("Bob");

        String clientsInfo = client1.getClient();

        assertEquals(clientsInfo, "Client: Bob   Pet:Coty");


    }

    @Test
    public void editClientName() throws Exception {
        Client client = new Client("Bob", new Cat("Coty"));
        Clinic clinic = new Clinic();
        clinic.addClient(client);

        clinic.editClientName("Bob", "Jeck");

        Client client1 = clinic.findClientByClientName("Jeck");
        String clientsInfo = client1.getClient();

        assertEquals(clientsInfo, "Client: Jeck   Pet:Coty");

    }

    @Test
    public void editPetName() throws Exception {
        Client client = new Client("Bob", new Cat("Coty"));
        Clinic clinic = new Clinic();
        clinic.addClient(client);

        clinic.editPetName("Coty", "KISI");

        Client client1 = clinic.findClientByClientName("Bob");
        String clientsInfo = client1.getClient();

        assertEquals(clientsInfo, "Client: Bob   Pet:KISI");
    }

    @Test
    public void deleteClient() throws Exception {
        Client client = new Client("Bob", new Cat("Coty"));
        Clinic clinic = new Clinic();
        clinic.addClient(client);

        clinic.deleteClient("Bob");

        assertEquals(clinic.myClients.getSize(), 0);
    }

    @Test
    public void addtoLinkedList() throws Exception {
        Client client1 = new Client("Bob1", new Cat("Coty1"));
        Client client2 = new Client("Bob2", new Cat("Coty2"));
        Client client3 = new Client("Bob3", new Cat("Coty3"));
        Client client4 = new Client("Bob4", new Cat("Coty4"));
//        MyLinkedList<Client> clientMyLinkedList = new MyLinkedList<>();
//        clientMyLinkedList.addNode(client1);
//        clientMyLinkedList.addNode(client2);
//        clientMyLinkedList.addNode(client3);
//        clientMyLinkedList.addNode(client4);
//        clientMyLinkedList.removeNode(new Client("Bob1", new Cat("Coty1")));
//        Client client = clientMyLinkedList.getNode(new Client("Bob3", new Cat("Coty31")));
//        assertEquals(clientMyLinkedList.getSize(), 3);

    }

    @Test
    public void mapTest() throws PetException, CreateClientException {
        Map<Client, String> clentMap = new HashMap();
        clentMap.put(new Client("Bob1", new Cat("Coty1")), "1");
        clentMap.put(new Client("Bob2", new Cat("Coty2")), "2");
        clentMap.put(new Client("Bob1", new Cat("Coty1")), "1");
        assertEquals(clentMap.size(), 2);

    }

    @Test
    public void setTest() throws PetException, CreateClientException {
        Set<Client> clentSet = new HashSet<>();
        clentSet.add(new Client("Bob1", new Cat("Coty1")));
        clentSet.add(new Client("Bob2", new Cat("Coty2")));
        clentSet.add(new Client("Bob1", new Cat("Coty1")));
        assertEquals(clentSet.size(), 2);

    }

    @Test
    public void ListSet() throws PetException, CreateClientException {
        List<Client> clientList = new LinkedList<>();
        clientList.add(new Client("Bob1", new Cat("Coty1")));
        clientList.add(new Client("Bob2", new Cat("Coty2")));
        clientList.add(new Client("Bob1", new Cat("Coty1")));
        assertEquals(clientList.size(), 3);

    }
}

/*    @Test
    public void threadClinicTest() throws InterruptedException {
        Clinic clinic = new Clinic();

        Manager manager = new Manager(clinic);
        manager.start();
        manager.join();
*//*        Doctor doctor = new Doctor(clinic);
        doctor.start();*//*




//        manager.join();

        Thread.sleep(2000);

        assertEquals(0, 0);
    }
}

class Manager extends Thread {
    Clinic clinic;
    static Integer clientNumber = 0;

    public Manager(Clinic clinic) {
        this.clinic = clinic;
    }

    @Override
    public void run() {
        try {
            Client client;
            for (int i = 0; i < 1000; i++) {
                client = new Client("Bob" + i, new Cat("Coty" + i));
                clinic.addClient(client);
                clientNumber++;
                System.out.println(client.getClientName());
            }
        } catch (CreateClientException e) {
            e.printStackTrace();
        } catch (PetException e) {
            e.printStackTrace();
        }

    }
}

class Doctor extends Thread {
    Clinic clinic;

    static Integer finishClirnt = 0;

    Doctor(Clinic clinic) {
        this.clinic = clinic;

    }

    @Override
    public void run() {
        while (true) {
            if(clinic.myClients.getSize()>0){
                try {
                    System.out.println("doctor" + clinic.deleteClient());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                break;
            }

        }

    }

}*/

