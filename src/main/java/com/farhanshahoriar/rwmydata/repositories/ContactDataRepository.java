package com.farhanshahoriar.rwmydata.repositories;


import com.farhanshahoriar.rwmydata.models.ContactData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactDataRepository extends MongoRepository<ContactData,String>{
	ContactData findBy_id(ObjectId _id);
}
