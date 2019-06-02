package ru.lesson.store;

import ru.lesson.lessons.*;
import ru.lesson.service.ClinicSettings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClinicJdbcStorage {
    private final Connection connection;

    public ClinicJdbcStorage(){
        final ClinicSettings settings = ClinicSettings.getSETTINGS();
        try {
            Class.forName(settings.values("jdbc.driver_class"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            this.connection = DriverManager.getConnection(settings.values("jdbc.url"),settings.values("jdbc.username"),settings.values("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }

    }

    public Collection<Client> getUsers(){
        List<Client> clients = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select c.name, p.name, p.type from client c join pet p on (c.name=p.clientname)");
            while(rs.next()){
                try {
                    try {
                        if(rs.getString(3).equals("cat")){
                            clients.add(new Client(rs.getString(1),new Cat(rs.getString(2))));
                        }else{
                            clients.add(new Client(rs.getString(1),new Dog(new Animal(rs.getString(2)))));
                        }

                    } catch (PetException e) {
                        e.printStackTrace();
                    }
                } catch (CreateClientException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    public void add(Client client){
        try(final PreparedStatement statement = this.connection.prepareStatement("insert into client values(?)")){
            statement.setString(1,client.getClientName());
            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try(final PreparedStatement statement = this.connection.prepareStatement("insert into pet(name, clientname, type) values (?,?, ?)")){
            statement.setString(1,client.getPet().getName());
            statement.setString(2,client.getClientName());

            if(client.getPet() instanceof Cat){
                statement.setString(3,"cat");
            }else{
                statement.setString(3,"dog");
            }
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteClient(String clientName) {
        try(final PreparedStatement statement = this.connection.prepareStatement("delete from pet where clientname = ?")){
            statement.setString(1,clientName);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(final PreparedStatement statement = this.connection.prepareStatement("delete from client where name = ?")){
            statement.setString(1,clientName);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void editClientName(String clientNameOld, String ClientNameNew){
        try(final PreparedStatement statement = this.connection.prepareStatement("update client set name= ? where name = ?")){
            statement.setString(1,ClientNameNew);
            statement.setString(2,clientNameOld);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void editPetName(String petNameOld, String petNameNew){
        try(final PreparedStatement statement = this.connection.prepareStatement("update pet set name= ? where name = ?")){
            statement.setString(1,petNameNew);
            statement.setString(2,petNameOld);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
