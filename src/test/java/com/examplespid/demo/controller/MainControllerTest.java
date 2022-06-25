package com.examplespid.demo.controller;

import com.examplespid.demo.entities.Spid;
import com.examplespid.demo.entities.Status;
import com.examplespid.demo.entities.User;
import com.examplespid.demo.repository.SpidR;
import com.examplespid.demo.repository.UserR;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class MainControllerTest {
    UserR userR;
    SpidR spidR;

    //User Testing
    //----------------------------------------//
    //Testing creating a user
    @Test
    void createUserTest(){
        try{
            User user = new User();
            user.setName("Kent");
            user.setUsername("Kent12");
            user.setEmail("kent@gmail.com");
            userR.save(user);
            Assertions.assertThat(user.getId()).isNotNull();
        }catch (Exception err){
            System.out.println(err.getMessage());
        }

    }

    //Testing updating a user
    @Test
    void updateUserTest() {
        try {
            User user = userR.findById(1L).get();
            user.setName("John");
            userR.save(user);
            Assertions.assertThat(user.getName()).isEqualTo("John");
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    //Spid Testing
    //---------------------------//
    //Testing get all Spids
    @Test
    void getAllSpidsTest() {
        try {
            Iterable<Spid> spids = spidR.findAll();
            Assertions.assertThat(spids).isNotNull();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    //Testing geting one spid
    @Test
    void getSpidTest() {
        try {
            Optional<Spid> spid = spidR.findById(1L);
            Assertions.assertThat(spid).isNotNull();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    //Testing Creating a Spid
    @Test
    void createSpidTest() {
        try {
            User user = userR.findById(1L).get();
            Spid spid = new Spid();
            spidR.save(spid);
            Assertions.assertThat(spid.getId()).isNotNull();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    //Testing changing a Spid Status
    @Test
    void changeSpidStatusTest() {
        try {
            Spid spid = spidR.findById(1L).get();
            spid.setStatus(Status.PENDING);
            spidR.save(spid);
            Assertions.assertThat(spid.getStatus()).isEqualTo(Status.PENDING);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    //Testing deleting a spid
    @Test
    void deleteSpidTest(){
        try {
            Spid spid = spidR.findById(1L).get();
            spidR.delete(spid);
            Assertions.assertThat(spidR.findById(1L)).isEmpty();
        }
        catch(Exception err){
            System.out.println(err.getMessage());
        }
    }
}
