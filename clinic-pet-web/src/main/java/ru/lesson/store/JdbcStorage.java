package ru.lesson.store;

import ru.lesson.models.User;
import ru.lesson.service.Settings;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class JdbcStorage implements Storage {
    private final Connection connection;

    public JdbcStorage() {
        final Settings setting  = Settings.getINSTANCE();
        try {
            Class.forName(setting.values("jdbc.driver_class"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection(setting.values("jdbc.url"), setting.values("jdbc.username"), setting.values("jdbc.password"));
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Collection<User> values() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from client");
            while (rs.next()) {
                users.add(new User(rs.getInt("uid"), rs.getString("login"), rs.getString("email")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public int add(User user) {
        try (final PreparedStatement statement = this.connection.prepareStatement("insert into client(login, email) values(?,?)", Statement.RETURN_GENERATED_KEYS)) {
            {
                statement.setString(1, user.getLogin());
                statement.setString(2, user.getEmail());
                statement.executeUpdate();
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        return generatedKeys.getInt(1);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new user");
    }

    @Override
    public void edit(User user) {
        try(PreparedStatement statement = connection.prepareStatement("update client set login = ?, email = ? where uid = ?")){

            statement.setString(1,user.getLogin());
            statement.setString(2,user.getEmail());
            statement.setInt(3,user.getId());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("delete from client where uid =?")) {
            {
                statement.setInt(1, id);
                statement.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User get(int id) {
        try (final PreparedStatement statement = this.connection.prepareStatement("select * from client where uid=(?)")) {
            statement.setInt(1, id);
            try{
                ResultSet rs = statement.executeQuery();
                while(rs.next()){
                    return new User(rs.getInt("uid"), rs.getString("login"), rs.getString("email"));
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new IllegalStateException(String.format("User %s does not exists", id));
    }

    @Override
    public User findByLogin(String login) {
        return null;
    }

    @Override
    public int generateId() {
        return 0;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
