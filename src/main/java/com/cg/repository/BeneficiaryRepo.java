package com.cg.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Bankaccount;
import com.cg.entity.Beneficiary;
import com.cg.entity.Customer;
import com.cg.entity.Wallet;

@Repository
public interface BeneficiaryRepo extends JpaRepository<Beneficiary, Integer> {

	/**
	 * 
	 * @param custid
	 * @return
	 */

	@Query(value = "SELECT * FROM Beneficiary b WHERE b.custid = ?1", nativeQuery = true)
	List<Beneficiary> getbycustomerid(int custid);

	/**
	 * 
	 * @param name
	 * @param mobile
	 * @param accno
	 * @return
	 */

	@Query(value = "SELECT count(*) FROM CUSTOMER c \r\n" + "INNER JOIN BANKACCOUNT b ON b.CUSTOMER_ID = c.CUSTID \r\n"
			+ "WHERE c.MOBILE = ?2 AND c.NAME = ?1 AND b.ACCOUNTNO = ?3 \r\n" + "", nativeQuery = true)
	int isBeneficiaryExists(String name, BigInteger mobile, BigInteger accno);

	/**
	 * 
	 * @param custid
	 * @param accno
	 * @return
	 */

	@Query(value = "SELECT count(*) FROM BENEFICIARY b WHERE b.CUSTID = ?1 AND b.ACCOUNTNO = ?2", nativeQuery = true)
	int isBenificiaryLinked(int custid, BigInteger accno);

	/**
	 * 
	 * @param bid
	 */

	@Query(value = "delete from beneficiary b where b.bid=?1 ", nativeQuery = true)
	void deleteBeneficiary(int bid);

}
