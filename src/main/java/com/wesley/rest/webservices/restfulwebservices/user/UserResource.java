package com.wesley.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//This is the controller for users

@RestController
public class UserResource {
    private UserDaoService service;

    public UserResource(UserDaoService service) {

        this.service = service;
    }

    //get Return all
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    //get Return specific
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if(user==null){ throw new UserNotFoundException("id" +id); }
        return user;
    }

    //post new user //This creates a user, returns a response of 201, and returns the new uri for the user
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = service.save(user);
        //Below, finds the URI path, informs the app to replace the {id}, finds the user that was created and saves the id, creates and saves the new uri (location) to be used in the response.
        //all this to say this saves the new uri.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build(); //all this does is return a response of a newly created uri and the response code.
    }
}
