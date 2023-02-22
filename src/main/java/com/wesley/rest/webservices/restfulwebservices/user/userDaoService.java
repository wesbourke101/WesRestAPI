package com.wesley.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//This is a service. Services are the actions controllers make. the business logic.


@Component
public class userDaoService {
    //JPA/Hibernate > Database
    //User/DaoService > Static List

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(30)));
        users.add(new User(2, "Eve", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Jim", LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    //public List<User> findAll() {

    //public User save(User user) {

    // public User findOne(int id) {

}
