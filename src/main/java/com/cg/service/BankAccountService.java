package com.cg.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Bankaccount;
import com.cg.entity.Billpayment;
import com.cg.repository.BankAccountRepo;
import com.cg.repository.WalletRepo;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountRepo baRepo;
	@Autowired
	private WalletRepo wRepo;

	/**
	 * 
	 * @param ba
	 * @return
	 */
	public Bankaccount addBankAccount(Bankaccount ba) {
		return baRepo.save(ba);

	}

	/**
	 * 
	 * @return
	 */

	public List<Bankaccount> getall() {
		// TODO Auto-generated method stub
		return baRepo.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	public Bankaccount getbyid(int id) {
		// TODO Auto-generated method stub
		return baRepo.findById(id).get();
	}

	/**
	 * 
	 * @param cu_id
	 * @param acc_no
	 * @return
	 */

	public double viewbalance(int cu_id, BigInteger acc_no) {
		return baRepo.viewBalance(cu_id, acc_no);
	}

	/**
	 * 
	 * @param bal
	 * @param acc_no
	 * @param custid
	 * @return
	 */

	public List<Bankaccount> updatebalance(double bal, BigInteger acc_no, int custid) {
		baRepo.updatebalance(bal, acc_no, custid);
		return baRepo.getAccountByCustId(custid);
	}

	/**
	 * 
	 * @param custid
	 * @return
	 */

	public ResponseEntity<String> deletebankaccount(int custid) {
		baRepo.deletebankaccount(custid);
		return new ResponseEntity<String>("beneficiary of " + custid + " is deleted", HttpStatus.OK);

	}

	/**
	 * 
	 * @param b
	 * @return
	 * @throws JSONException
	 */

	public ResponseEntity<String> addmoneytowallet(Bankaccount b) throws JSONException {

		BigInteger acc_no = b.getAccountno();
		int cust_id = b.getCustomer_id();
		int wallet_id = wRepo.getWalletidfromcustid(cust_id);
		double amount = b.getBalance();
		double balance = baRepo.viewBalance(cust_id, acc_no);

		if (amount <= balance) {
			baRepo.withdrawmoney(amount, acc_no, cust_id);
			wRepo.addmoneytowallet(wallet_id, amount);
		} else {
			return new ResponseEntity<String>("Insufficient balance", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Added money to the wallet", HttpStatus.OK);

	}

}
