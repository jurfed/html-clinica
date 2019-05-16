package ru.lesson.lessons;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jur on 04.01.2019.
 */
public class Clinic {
    MyLinkedList myClients;

    public MyLinkedList getMyClients() {
        return myClients;
    }

    public Clinic() {
        this.myClients = new MyLinkedList();
    }

    public void addClient(final Client client) {

            this.myClients.addNode(client);

    }

    public Client findClientByPetName(final String petName) {
        return myClients.getNodeByPetName(petName);
    }

    public Client findClientByClientName(final String clientName) {
        return myClients.getNodeByClientName(clientName);

    }

    public void editClientName(String firstName, String lastName) throws PetException {
        Client client = myClients.getNodeByClientName(firstName);
        client.setId(lastName);
    }

    public void editPetName(String firstName, String lastName) {
        Client client = myClients.getNodeByPetName(firstName);
        client.getPet().setName(lastName);
    }

    public void deleteClient(String clientName) {
        myClients.removeNode(myClients, findClientByClientName(clientName));
    }

    /**
     * Получение списка клиентов
     *
     * @return
     */
    public void printClients() {
        System.out.println(myClients.toString());
    }

    /**
     * Получение списка клиентов
     *
     * @return
     */
    public String getClients() {

        return myClients.toString();
    }


    public List<Client> getClientList(){

        return myClients.getNodeList();
    }

    public String deleteClient() throws InterruptedException {
        synchronized(this.myClients){
            while(myClients.getSize()==0){
                this.myClients.wait();
            }
        }
        String deletedClient = myClients.removeRandomNode();
        return deletedClient;
    }

}
