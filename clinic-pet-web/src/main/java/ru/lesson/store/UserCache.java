package ru.lesson.store;


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
public class UserCache {

    // singleton - экземляр класса
    private static final UserCache INSTANCE = new UserCache();
    public static UserCache getInstance() {
        return INSTANCE;
    }

    //карта идентификаторов и пользователей
    private final ConcurrentHashMap<Integer, User> users = new ConcurrentHashMap<Integer, User>();

    //коллекция пользователей
    public Collection<User> values() {
        return this.users.values();
    }

    public void add(final User user) {
        this.users.put(user.getId(), user);
    }

    public void edit(final User user) {
        this.users.replace(user.getId(), user);
    }

    public void delete(final int id) {
        this.users.remove(id);
    }

    public User get(final int id) {
        return this.users.get(id);
    }
}
