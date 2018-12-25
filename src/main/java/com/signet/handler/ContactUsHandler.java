package com.signet.handler;

import java.util.Iterator;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.ContactUsDto;
import com.signet.exception.NotFoundException;
import com.signet.model.ContactUs;
import com.signet.repository.ContactUsRepository;

@Service
public class ContactUsHandler {

	@Autowired
	private ContactUsRepository repository;

	public ContactUs getContactUsOne(Long id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("contactUsId", String.valueOf(id)));
	}

	public Iterator<ContactUs> getContactUs() {
		return repository.findAll().iterator();
	}

	public ContactUs saveContactUs(ContactUsDto contactUsDto) {
		ContactUs contactUs = new ContactUs();
		BeanUtils.copyProperties(contactUsDto, contactUs);
		return repository.save(contactUs);
	}

	public ContactUs updateContactUs(long id, ContactUsDto contactUsDto) {
		ContactUs contactUs = getContactUsOne(id);
		contactUs.setFullName(contactUsDto.getFullName());
		contactUs.setEmail(contactUsDto.getEmail());
		contactUs.setContact(contactUsDto.getContact());
		contactUs.setMessage(contactUsDto.getMessage());
		return repository.save(contactUs);
	}

	public boolean deleteContactUs(Long id) {
		ContactUs contactUs = getContactUsOne(id);
		repository.delete(contactUs);
		return true;
	}

}
