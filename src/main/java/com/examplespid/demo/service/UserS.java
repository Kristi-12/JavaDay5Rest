package com.examplespid.demo.service;

import com.examplespid.demo.entities.User;
import org.springframework.stereotype.Service;
import com.examplespid.demo.repository.UserR;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserS {
    UserR userR ;


    UserS(UserR userR){
        this.userR = userR;
    }

    //Create user
    public User createUser(User user) throws Exception {
        Optional<User> findIfUserExists = userR.findUserById(user.getId());

        if (findIfUserExists.isPresent()) {
            throw new Exception("User exists!");
        }
        return userR.save(user);
    }

    //Get User
    public User getUserById(Long id) {
        return userR.findById(id).get();
    }

    //Update User
    public User updateUser(User user , long id) throws Exception{
        if(userR.findUserById(id).isPresent()){
            user.setId(id);
            return userR.save(user);
        }
        else
        {
        throw new Exception("User doesn't exist!");
        }
    }

    //Get all Users
    public Iterable<User> retriveAllUsers() {

        return userR.findAll();
    }

    //Delete User
    @Transactional
    public void deleteUser(long id){
        userR.deleteById(id);
    }
}
