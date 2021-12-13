package com.cg.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Bankaccount;
import com.cg.entity.Customer;
import com.cg.entity.Wallet;
import com.cg.repository.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	CustomerRepo customerrepo;

	/**
	 * 
	 * @param c
	 * @return
	 */

	public Customer addCustomer(Customer c) {
		return customerrepo.save(c);

	}

	/**
	 * 
	 * @return
	 */

	public List<Customer> getall() {
		return customerrepo.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	public Customer getbyid(int id) {
		return customerrepo.findById(id).get();
	}

	/**
	 * 
	 * @param mobile
	 * @param password
	 * @return
	 */

	public Customer login(BigInteger mobile, String password) {
		return customerrepo.login(mobile, password);
	}

	/**
	 * 
	 * @param mobile
	 * @return
	 */

	public Customer findBymobile(BigInteger mobile) {
		return customerrepo.findBymobile(mobile);
	}

}
