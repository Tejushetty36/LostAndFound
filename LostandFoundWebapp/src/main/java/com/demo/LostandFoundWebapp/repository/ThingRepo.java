package com.demo.LostandFoundWebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.LostandFoundWebapp.entity.Thing;

@Repository
public interface ThingRepo extends JpaRepository<Thing, Integer> {

	List<Thing> findByNameContainsAllIgnoreCase(String name);

}
