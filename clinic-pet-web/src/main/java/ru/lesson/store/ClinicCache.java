package ru.lesson.store;

import ru.lesson.lessons.*;
import ru.lesson.models.User;

import java.util.Collection;
import java.util.List;

public class ClinicCache {
    Clinic clinic;

    private static final ClinicCache CLINIC_CACHE  = new ClinicCache();

    private final ClinicJdbcStorage storage = new ClinicJdbcStorage();


    private ClinicCache(){
        clinic = new Clinic();
        Collection<Client> clients = storage.getUsers();
        clients.forEach(client->{
            clinic.addClient(client);
        });

    }

    public void add(Client client){
        storage.add(client);
    }

    public void delete(String clientName){
        storage.deleteClient(clientName);
    }

    public void editClient(String oldName, String newName){
        storage.editClientName(oldName, newName);
    }

    public void editPet(String oldName, String newName){
        storage.editPetName(oldName, newName);
    }

    public static ClinicCache getInstance(){
        return CLINIC_CACHE;
    }

    public Clinic getClinic() {
        clinic = new Clinic();
        Collection<Client> clients = storage.getUsers();
        clients.forEach(client->{
            clinic.addClient(client);
        });
        return clinic;
    }
}
