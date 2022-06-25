package com.examplespid.demo.repository;

import com.examplespid.demo.entities.Spid;
import com.examplespid.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpidR extends CrudRepository<Spid , Long> {
    Optional<Spid> findSpidByUserId(User user);

}
