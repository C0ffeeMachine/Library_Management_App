package com.example.MyApp1.Controller;

import com.example.MyApp1.DataAccessLayer.User;
import com.example.MyApp1.DataAccessLayer.UserRepository;
import com.example.MyApp1.Util.UserValidator;
import com.example.MyApp1.exception.UserNameMissingException;
import com.example.MyApp1.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserResource {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    UserValidator validator = new UserValidator();

    @Autowired
    private UserRepository repository;
    // Find
    @GetMapping("/users")
    List<User> findAll() {
        return repository.findAll();
    }

    @PostMapping("/users")
    //return 201 instead of 200
    @ResponseStatus(HttpStatus.CREATED)
    User newUser(@RequestBody User newUser) {
        if(validator.isValid(newUser))
            return repository.save(newUser);
        else {
            LOGGER.severe("Name field is empty! ");
            throw new UserNameMissingException();
        }
    }

    // Find a given user
    @GetMapping("/users/{id}")
    User findOne(@PathVariable int id) {
        LOGGER.info("/users/{id} called with id "+ id);
        // Optional<User> user = repository.findById(id);
        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

}