package com.intraway.fizzbuzz.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intraway.fizzbuzz.api.entities.EntityRequest;

@Repository
public interface RequestRepository extends JpaRepository<EntityRequest, Integer> {

}
