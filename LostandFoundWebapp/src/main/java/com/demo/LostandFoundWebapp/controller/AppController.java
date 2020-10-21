package com.demo.LostandFoundWebapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.LostandFoundWebapp.entity.Thing;
import com.demo.LostandFoundWebapp.service.ThingService;



@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private ThingService service;
	
	
	@GetMapping("/list")
	public String getItemsList(Model theModel)
	{
		List<Thing> lostThingsList = service.getItemsList();
		
		theModel.addAttribute("ItemsList", lostThingsList);
		
		return "listItems";
	}
	
	@GetMapping("/showFormForAdd")
	public String showAddLostItemForm(Model theModel) {
		
		Thing newThing = new Thing();
		
		theModel.addAttribute("LostThing", newThing);
		
		return "LostThingForm";
		
	}
	
	@PostMapping("/save")
	public String addNewCustomer(@Valid @ModelAttribute("LostThing")Thing theThing,BindingResult errors) throws Exception {
		
		if(errors.hasErrors())
		{
			// Extract ConstraintViolation list from body errors
            List<ConstraintViolation<?>> violationsList = new ArrayList<>();
            for (ObjectError e : errors.getAllErrors()) {
                violationsList.add(e.unwrap(ConstraintViolation.class));
            }
        
                String exceptionMessage = "";
        
             // Construct a helpful message for each input violation
            for (ConstraintViolation<?> violation : violationsList) {
                    exceptionMessage += violation.getPropertyPath() + " " + violation.getMessage() + "\n";
                }
            throw new Exception(String.format("Request input is invalid:\n%s", exceptionMessage));
		}
		
		service.addLostThing(theThing);
		
		return "redirect:/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdateCustomer(@RequestParam("ItemId")int theId,Model theModel)
	{
		Thing persistedThing = service.getItemById(theId);
		
		theModel.addAttribute("LostThing", persistedThing);
		
		return "LostThingForm";
	}
	
	@GetMapping("/deleteItem")
	public String deleteCustomer(@RequestParam("ItemId")int theId)
	{
		service.deleteItem(theId);
		
		return "redirect:/list";
	}
	
	@GetMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName")String name,Model theModel) {
		
		List<Thing> persistedThingsList = service.searchItemsList(name);
		
		theModel.addAttribute("ItemsList", persistedThingsList);
		
		return "listItems";
		
	}

}
