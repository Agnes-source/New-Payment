package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.entity.Bankaccount;
import com.cg.entity.Billpayment;
import com.cg.entity.Customer;
import com.cg.entity.Userprofile;
import com.cg.entity.Wallet;
import com.cg.repository.BankAccountRepo;

@Service
public class SignupService {

	@Autowired
	private WalletService walletservice;
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private BankAccountService baccountservice;

	/**
	 * 
	 * @param up
	 * @return
	 */

	public ResponseEntity<String> addUserProfile(Userprofile up) {
		Customer validate = customerservice.findBymobile(up.getMobile());
		if (validate == null) {
			Wallet w = walletservice.addWallet(new Wallet(0, 0));
			Customer cu = customerservice
					.addCustomer(new Customer(0, up.getName(), up.getMobile(), w.getWalletid(), up.getPassword()));
			Bankaccount ba = baccountservice.addBankAccount(new Bankaccount(up.getAccountno(), up.getIfsccode(),
					up.getBankName(), cu.getCustid(), up.getBalance()));

			return new ResponseEntity<String>(HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Mobile Number Already Exists.", HttpStatus.PRECONDITION_FAILED);
		}
	}

	/**
	 * 
	 * @param up
	 * @return
	 */

	public Customer getUserprofile(Userprofile up) {
		System.out.println("sigin services called with " + up.getMobile() + " " + up.getPassword());
		return customerservice.login(up.getMobile(), up.getPassword());
	}

}
