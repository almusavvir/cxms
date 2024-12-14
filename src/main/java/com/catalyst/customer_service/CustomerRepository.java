package com.catalyst.customer_service;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

      @Query("{ 'firstName' : { '$regex' : ?0, '$options' : 'i' } }")
      List<Customer> findByFirstNameIgnoreCase(String firstName);
}
