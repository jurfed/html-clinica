package ru.lesson.lessons;

/**
 * Created by jur on 04.01.2019.
 */
public class Client {
    private String id;
    private Pet pet;

    public Client(){}


    public Client(String id, Pet pet) throws CreateClientException {
        if (id == null || id.equals("") || pet == null) {
            throw new CreateClientException("id or pet must not be null");
        } else {
            this.id = id;
            this.pet = pet;
        }
    }

    public String getPetClass() {
        String petClass="Котопес";
        if (pet instanceof Cat){
            petClass = "Кошка";
        }else if(pet instanceof Dog){
            petClass="Собака";
        }

        return petClass;
    }

    public Pet getPet() {
        return pet;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) throws PetException {
        if (id == null || id.equals("") || id.length() < 2) {
            throw new PetException("Client name(id) must be >1");
        }
        this.id = id;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Client: " + id + "   Pet:" + pet.getName();
    }

    public String getClient() {
        return "Client: " + id + "   Pet:" + pet.getName();
    }

    public String getClientName() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        return pet != null ? pet.equals(client.pet) : client.pet == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pet != null ? pet.hashCode() : 0);
        return result;
    }
}
