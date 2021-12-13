package com.cg.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Billpayment;
import com.cg.entity.Customer;
import com.cg.entity.Wallet;
import com.cg.repository.BillpaymentRepo;
import com.cg.repository.CustomerRepo;

@Service
public class BillpaymentService {
	@Autowired
	BillpaymentRepo billpaymentrepo;

	/**
	 * 
	 * @param b
	 * @return
	 */

	public Billpayment addBill(Billpayment b) {

		b.setDdate(new Date());
		return billpaymentrepo.save(b);

	}

	/**
	 * 
	 * @return
	 */

	public List<Billpayment> getall() {
		// TODO Auto-generated method stub
		return billpaymentrepo.findAll();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	public Billpayment getbyid(int id) {
		// TODO Auto-generated method stub
		return billpaymentrepo.findById(id).get();
	}

}
