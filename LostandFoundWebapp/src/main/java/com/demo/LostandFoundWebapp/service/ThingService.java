package com.demo.LostandFoundWebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.LostandFoundWebapp.entity.Thing;
import com.demo.LostandFoundWebapp.repository.ThingRepo;

@Service
public class ThingService {
	
	
	@Autowired
	private ThingRepo dao;
	
	public List<Thing> getItemsList() {		
		return dao.findAll();
	}

	public void addLostThing(Thing theThing) {
		
		dao.save(theThing);
		
	}

	public Thing getItemById(int theId) {
		return dao.findById(theId).get();
	}

	public void deleteItem(int theId) {
		Thing persistedItem = getItemById(theId);
		dao.delete(persistedItem);
	}

	public List<Thing> searchItemsList(String name) {
		// TODO Auto-generated method stub
		return dao.findByNameContainsAllIgnoreCase(name);
	}
	
	
	

}
