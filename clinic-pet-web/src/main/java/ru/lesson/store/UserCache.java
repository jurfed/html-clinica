package ru.lesson.store;


import ru.lesson.models.Message;
import ru.lesson.models.User;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Уласс - singleton, содержащий спиок пользователей.
 * Можно добавлять, удалять, редактировать пользователей
 *
 * @author jurfed
 * @since 18.04.2015
 */
public class UserCache implements Storage {

    // singleton - экземляр класса
    private static final UserCache INSTANCE = new UserCache();
    //    private final Storage storage = new MemomryStorage();
//    private final Storage storage = new JdbcStorage();
    private final Storage storage = new HibernateStorage();

    public static UserCache getInstance() {
        return INSTANCE;
    }

    //коллекция пользователей
    public Collection<User> values() {
        return this.storage.values();
    }

    @Override
    public int add(final User user) {
        return this.storage.add(user);
    }

    public void edit(final User user) {
        this.storage.edit(user);
    }

    public void delete(final int id) {
        this.storage.delete(id);
    }

    public User get(final int id) {
        return this.storage.get(id);
    }

    @Override
    public User findByLogin(String login) {
        return this.storage.findByLogin(login);
    }

    @Override
    public int generateId() {
        return this.storage.generateId();
    }

    @Override
    public void close() {
        this.storage.close();
    }

    @Override
    public void addMessage(Message message) {
        this.storage.addMessage(message);
    }
}
