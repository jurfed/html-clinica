package ru.lesson.store;

import org.junit.Test;
import ru.lesson.models.User;

import static org.junit.Assert.*;
public class JdbcStorageTest {

    @Test
    public void testCreate() throws Exception{
        final JdbcStorage storage = new JdbcStorage();
        final int id=storage.add(new User(-1,"test", "test"));

        final User user = storage.get(id);
        assertEquals(id, user.getId());
        storage.close();
    }

}
