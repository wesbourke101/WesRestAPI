package com.wesley.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


//This is a service. Services are the actions the controller needs to work. the business logic.


@Component
public class UserDaoService {
    //JPA/Hibernate > Database
    //User/DaoService > Static List

    private static List<User> users = new ArrayList<>();
    private static int usersCount = 0;

    //.add() is just something that is built in you don't need to create it. I think it's in the List class??
    static {
        users.add(new User(++usersCount, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Jim", LocalDate.now().minusYears(20)));
    }

    //public List<User> findAll() {
    public List<User> findAll() {
        return users;
    }

    //public User save(User user) {
    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    // public User findOne(int id) {
    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id); //did not need to use the ? or super.
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
}
