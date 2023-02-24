package com.wesley.rest.webservices.restfulwebservices.user;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//Services //This feels like an error handling services. So far just for one error.

@ResponseStatus(code = HttpStatus.NOT_FOUND) //this dictates what blanket error message will come back. This does the 404
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        super(message);
    }
}
