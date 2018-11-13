package com.signet.handler;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signet.dto.CustomerDto;
import com.signet.model.Customer;
import com.signet.repository.CustomerRepository;

@Service
public class CustomerHandler {
		
	@Autowired
	private CustomerRepository customerRepository;
	
	public Customer getCustomerOne(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		
		if(customerOptional.isPresent()) {
			return customerOptional.get();
		}
		return null;
	}
	
	public Iterator<Customer> getCustomers() {
		return customerRepository.findAll().iterator();
	}
	
	public Customer saveCustomer(CustomerDto customerDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDto, customer);
		return customerRepository.save(customer);
	}

}
