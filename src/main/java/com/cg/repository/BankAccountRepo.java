package com.cg.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Bankaccount;
import com.cg.entity.Wallet;

@Repository
public interface BankAccountRepo extends JpaRepository<Bankaccount, Integer> {

	/**
	 * 
	 * @param custid
	 * @param accountno
	 * @return
	 */

	@Query(value = "select balance from bankaccount where customer_id=?1 and accountno=?2", nativeQuery = true)
	double viewBalance(int custid, BigInteger accountno);

	/**
	 * 
	 * @param custid
	 * @return
	 */

	@Query(value = "select * from bankaccount where customer_id=?1", nativeQuery = true)
	List<Bankaccount> getAccountByCustId(int custid);

	/**
	 * 
	 * @param bal
	 * @param acc_no
	 * @param custid
	 */

	@Transactional
	@Modifying
	@Query(value = "update bankaccount set balance=(balance+?1) where accountno=?2 and customer_id=?3", nativeQuery = true)
	void updatebalance(double bal, BigInteger acc_no, int custid);

	/**
	 * 
	 * @param custid
	 */

	@Query(value = "delete from bankaccount where customer_id=?1", nativeQuery = true)
	void deletebankaccount(int custid);

	/**
	 * 
	 * @param amount
	 * @param acc_no
	 * @param custid
	 */

	@Transactional
	@Modifying
	@Query(value = "update bankaccount set balance=(balance-?1) where accountno=?2 and customer_id=?3", nativeQuery = true)
	void withdrawmoney(double amount, BigInteger acc_no, int custid);
	
	/*
	 * get the customerid from walletid and return the amount
	 */
	@Query(value = "select balance from bankaccount where customer_id=?1 ", nativeQuery = true)
	double viewBalanceByCustomerId(int custid);

	/*
	 * reduce the amount for wallet only by amount and customerid only
	 */
	@Transactional
	@Modifying
	@Query(value = "update bankaccount set balance=(balance-?1) where  customer_id=?2", nativeQuery = true)
	void withdrawmoneyForWallet(double amount, int custid);

}
