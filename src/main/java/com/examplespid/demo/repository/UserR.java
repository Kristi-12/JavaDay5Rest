package com.examplespid.demo.repository;

import com.examplespid.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserR extends CrudRepository<User , Long> {
    Optional<User> findUserById(long id);
}
