package com.cg.controller;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Bankaccount;
import com.cg.entity.Beneficiary;
import com.cg.entity.Billpayment;
import com.cg.entity.Customer;
import com.cg.entity.Wallet;
import com.cg.service.BankAccountService;
import com.cg.service.BeneficiaryService;
import com.cg.service.BillpaymentService;
import com.cg.service.CustomerService;
import com.cg.service.WalletService;

@RestController
@RequestMapping("app/beneficiary")
public class BeneficiaryController {

	@Autowired
	private BeneficiaryService beneService;

	/**
	 * 
	 * @param bene
	 * @return
	 * @throws JSONException
	 */
	@PostMapping(value = "/add_beneficiary", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Beneficiary> addBeneficiary(@RequestBody Beneficiary bene) throws JSONException {

		if (beneService.isBeneficiaryExists(bene.getName(), bene.getMobilenumber(), bene.getAccountno()) <= 0) {
			return null;
		} else {
			if (beneService.isBenificiaryLinked(bene.getCustid(), bene.getAccountno()) <= 0) {
				return beneService.addBeneficiary(bene);
			} else {
				return beneService.getbycustomerid(bene.getCustid());
			}
		}
	}

	/**
	 * 
	 * @return
	 */

	@GetMapping("/getall")
	public List<Beneficiary> getAll() {
		return beneService.getall();
	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/getbycustomerid/{id}") // end point
	public List<Beneficiary> getbycustomerid(@PathVariable("id") int id) {
		return beneService.getbycustomerid(id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	@PostMapping("/deleteBeneficiary/{id}")
	public ResponseEntity<String> deletebeneficiary(@PathVariable("id") int id) {
		return beneService.deletebeneficiary(id);
	}

}
