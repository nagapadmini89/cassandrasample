package com.cassandra.example.springbootcassandraexample.repository;

import com.cassandra.example.springbootcassandraexample.model.UserTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserTable, Serializable> {

    Optional<UserTable> findByIdAndName(String id, String name);
}
