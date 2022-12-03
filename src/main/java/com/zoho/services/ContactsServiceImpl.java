package com.zoho.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.zoho.entities.Contacts;
import com.zoho.entities.Lead;
import com.zoho.repositories.ContactsRepository2;
import com.zoho.repositories.LeadRepository;

@Service 
public class ContactsServiceImpl implements ContactsService {
	
	@Autowired
	private ContactsRepository2 contactsRepo;

	@Override
	public void saveContactsInformation(Contacts contacts) {
		contactsRepo.save(contacts);
	}


	@Override
	public List<Contacts> getAllContacts() {
		List<Contacts> contacts = contactsRepo.findAll();
		return contacts;
	}


	@Override
	public Contacts findContactsById(long id) {
		Optional<Contacts> findById = contactsRepo.findById(id);
		Contacts contacts = findById.get();
		return contacts;
	}

}
