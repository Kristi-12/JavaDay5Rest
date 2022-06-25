package com.examplespid.demo.controller;


import com.examplespid.demo.entities.Spid;
import com.examplespid.demo.entities.User;
import com.examplespid.demo.service.SpidS;
import com.examplespid.demo.service.UserS;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class MainController {
    UserS userS;
    SpidS spidS;
    MainController(UserS userS, SpidS spidS) {
        this.userS = userS;
        this.spidS = spidS;
    }

    //User Controller
    //------------------------------------------------------//
    //Creating a user
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user)
        throws Exception{
        return new ResponseEntity<>(userS.createUser(user), HttpStatus.OK);
    }

    //Get all Users
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity(userS.retriveAllUsers(),HttpStatus.OK);
    }


    //Update a user
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable long id)
            throws Exception {
        return new ResponseEntity<>(userS.updateUser(user, id), HttpStatus.OK);
    }
    //Delete a user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") long id)
            throws Exception {
        return new ResponseEntity("User is deleted", HttpStatus.OK);
    }

    //Spid Controller
    //---------------------------------------------//

    //Create a Spid
    @PostMapping("/spid")
    public ResponseEntity<Spid> createSpid(@RequestBody Spid spid)
            throws Exception {
        return new ResponseEntity(spidS.createSpid(spid), HttpStatus.OK);
    }

    //Get all spids
    @GetMapping("/spid")
    public ResponseEntity<List<Spid>> getAllSpids() {
        return new ResponseEntity(spidS.retriveAllSpids(), HttpStatus.OK);
    }

    //Get one Spid by id
    @GetMapping("/spid/{id}")
    public ResponseEntity<Spid> getSpid(@PathVariable(name = "id") long id)
            throws Exception {
        return new ResponseEntity(spidS.findSpidById(id), HttpStatus.OK);
    }

    //Change spid status
    @PutMapping("/spid/{id}")
    public ResponseEntity<Spid> deleteSpid(@PathVariable(name = "id") long id)
            throws Exception {
        return new ResponseEntity(spidS.changeStatus(id) , HttpStatus.OK);
    }

}
