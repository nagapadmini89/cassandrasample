package com.cassandra.example.springbootcassandraexample.controller;

import com.cassandra.example.springbootcassandraexample.model.UserTable;
import com.cassandra.example.springbootcassandraexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "{id}/{name}")
    public ResponseEntity<UserTable> getByIdAndName(@PathVariable("id") String id,
                                                    @PathVariable("name") String name){
        Optional<UserTable> getData = userRepository.findByIdAndName(id,name);
        if (!getData.isPresent()) {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(getData.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserTable> addUser(@RequestBody UserTable userTable) {
        UserTable savedData = userRepository.save(userTable);
        return new ResponseEntity<>(savedData, HttpStatus.OK);
    }


}
