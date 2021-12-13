package com.cg.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Wallet;

@Repository
public interface WalletRepo extends JpaRepository<Wallet, Integer> {

	/**
	 * 
	 * @param bal
	 * @param walletid
	 */
	@Transactional
	@Modifying
	@Query(value = "update wallet set balance=?1 where walletid=?2", nativeQuery = true)
	void updatebalance(double bal, int walletid);

	/**
	 * 
	 * @param cid
	 * @return
	 */

	@Query(value = "select balance from wallet where walletid=?1", nativeQuery = true)
	double getbalance(int cid);

	/**
	 * 
	 * @param cid
	 * @param amount
	 */

	@Transactional
	@Modifying
	@Query(value = "update wallet set balance=(balance+?2) where walletid=?1", nativeQuery = true)
	void addmoneytowallet(int cid, double amount);

	/**
	 * 
	 * @param cust_id
	 * @return
	 */

	@Query(value = "SELECT Wallet_id FROM CUSTOMER c WHERE c.CUSTID =?1", nativeQuery = true)
	int getWalletidfromcustid(int cust_id);

}
