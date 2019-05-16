package ru.lesson.store;

import ru.lesson.lessons.*;

public class ClinicCache {
    Clinic clinic;

    private static final ClinicCache CLINIC_CACHE  = new ClinicCache();


    private ClinicCache(){
        clinic = new Clinic();
        try {
            for(int i=1; i<3; i++){
                clinic.addClient(new Client("Bob"+i, new Cat("Cat"+i)));
                clinic.addClient(new Client("Alice"+i, new Dog(new Animal("Dog"+i))));
            }
        } catch (CreateClientException e) {
            e.printStackTrace();
        } catch (PetException e) {
            e.printStackTrace();
        }

    }

    public static ClinicCache getInstance(){
        return CLINIC_CACHE;
    }

    public Clinic getClinic() {
        return clinic;
    }
}
