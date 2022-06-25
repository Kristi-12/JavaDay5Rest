package com.examplespid.demo.service;

import com.examplespid.demo.entities.Spid;
import com.examplespid.demo.entities.Status;
import com.examplespid.demo.entities.User;
import org.springframework.stereotype.Service;
import com.examplespid.demo.repository.SpidR;
import com.examplespid.demo.repository.UserR;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class SpidS {

    SpidR spidR;
    UserR userR;

    SpidS (SpidR spidR , UserR userR){
        this.spidR = spidR;
        this.userR = userR;
    }

    @Transactional
    //Create Spid
    public Spid createSpid(Spid spid) throws Exception{
        Optional<Spid> currentSpid = spidR.findSpidByUserId(spid.getUserId());
        Optional<User> user = userR.findById(spid.getUserId().getId());
        if(currentSpid.isPresent()){
            throw new Exception("User exist!");
        }
        if(!user.isPresent()){
            throw new Exception("User doesn't exist");
        }
        return spidR.save(spid);
    }

    //Get all Spids
    public Iterable<Spid> retriveAllSpids() {
        return spidR.findAll();
    }

    //Get one Spid
    public Spid findSpidById(long id) throws Exception {
        Optional<Spid> spid = spidR.findById(id);
        if(!spid.isPresent()){
            throw new Exception("Spid doesn't exist");
        }
        return spid.get();
    }

    //Delete Spid
    @Transactional
    public void deleteSpid(long id){
        spidR.deleteById(id);
    }

    //Change Spid status
    public Spid changeStatus(long id) throws Exception {
        Spid spid = findSpidById(id);
        spid.setStatus(Status.READY_FOR_REVIEW);
        return spidR.save(spid);
    }

}
