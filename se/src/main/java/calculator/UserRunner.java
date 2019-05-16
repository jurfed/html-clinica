package calculator;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jur on 07.01.2019.
 */
public class UserRunner {
    public static void main(String [] srg){
        System.out.println("1");
        List<User> userList = new ArrayList<User>();
        userList.add(new User("1","Sasha"));
        userList.add(new User("2","Petya"));
        userList.add(new User("1","Sasha"));

        userList.stream().peek(user -> System.out.println(user)).collect(Collectors.toList());

        System.out.println("2");
        List<User> linkedList = new LinkedList<>();
        linkedList.add(new User("1","Sasha"));
        linkedList.add(new User("2","Petya"));
        linkedList.add(new User("1","Sasha"));

        linkedList.stream().peek(user -> System.out.println(user)).collect(Collectors.toList());

        System.out.println("3");
        Set<User> userSet = new HashSet<User>();
        userSet.add(new User("1","Sasha"));
        userSet.add(new User("2","Petya"));
        userSet.add(new User("1","Sasha"));

        userSet.stream().peek(user -> System.out.println(user)).collect(Collectors.toList());
    }
}
