package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entity.Customer;
import com.cg.entity.Wallet;
import com.cg.repository.BankAccountRepo;
import com.cg.repository.WalletRepo;

@Service
public class WalletService {

	@Autowired
	private WalletRepo wRepo;
	@Autowired
	private BankAccountRepo baRepo;

	/**
	 * 
	 * @param w
	 * @return
	 */
	public Wallet addWallet(Wallet w) {
		return wRepo.save(w);

	}

	/**
	 * 
	 * @return
	 */

	public List<Wallet> getall() {
		// TODO Auto-generated method stub
		return wRepo.findAll();

	}

	/**
	 * 
	 * @param id
	 * @return
	 */

	public Wallet showBalance(int id) {
		// TODO Auto-generated method stub
		return wRepo.findById(id).get();
	}

	/**
	 * 
	 * @param bal
	 * @param walletid
	 * @return
	 */

	public Wallet updateBalance(double bal, int walletid) {
		int customer_id=wRepo.getWalletidfromcustid(walletid);
		double CurrentBankAmount=baRepo.viewBalanceByCustomerId(customer_id);
		if((walletid==0) && (bal==0) && (CurrentBankAmount >= bal)) {
			return null;
		}
		else {
			wRepo.addmoneytowallet(walletid,bal);
			baRepo.withdrawmoneyForWallet(bal, customer_id);
			return wRepo.findById(walletid).get();
		}
		
	}

}
