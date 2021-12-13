package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Billpayment;
import com.cg.service.BillpaymentService;

@RestController
@RequestMapping("app/billpayment")
public class BillPaymentController {

	@Autowired
	private BillpaymentService billpaymentservice;

	/**
	 * 
	 * @param bill
	 * @return
	 */
	@PostMapping("/add_billpayment")
	public Billpayment addBill(@RequestBody Billpayment bill) {
		return billpaymentservice.addBill(bill);
	}

	/**
	 * 
	 * @return
	 */

	@GetMapping("/getall")
	public List<Billpayment> getAll() {
		return billpaymentservice.getall();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/getbyid/{id}")
	public Billpayment getbyid(@PathVariable("id") int id) {
		return billpaymentservice.getbyid(id);
	}

}
