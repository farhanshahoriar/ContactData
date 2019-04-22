package com.farhanshahoriar.rwmydata;

import com.farhanshahoriar.rwmydata.models.ContactData;
import com.farhanshahoriar.rwmydata.repositories.ContactDataRepository;

import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactDataController {
	@Autowired
	  private ContactDataRepository repository;
	  
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public List<ContactData> getAllContactData() {
		  
	    return repository.findAll();
	  }

	  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
	  public ContactData getContactById(@PathVariable("id") ObjectId id) {
		  System.out.println(repository.findBy_id(id).getName());
	      return repository.findBy_id(id);
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	  public void modifyContactById(@PathVariable("id") ObjectId id, @Valid @RequestBody ContactData ContactData) {
	    ContactData.set_id(id);
	    repository.save(ContactData);
	  }
	  
	  @RequestMapping(value = "/", method = RequestMethod.POST)
	  public ContactData createContact(@Valid @RequestBody ContactData ContactData) {
	    ContactData.set_id(ObjectId.get());
	    repository.save(ContactData);
	    return ContactData;
	  }
	  
	  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	  public void deleteContact(@PathVariable ObjectId id) {
	    repository.delete(repository.findBy_id(id));
	}
}
