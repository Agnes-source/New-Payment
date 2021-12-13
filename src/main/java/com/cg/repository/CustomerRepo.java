package com.cg.repository;

import java.math.BigInteger;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Bankaccount;
import com.cg.entity.Customer;
import com.cg.entity.Wallet;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	/**
	 * 
	 * @param mobile
	 * @param password
	 * @return
	 */

	@Query(value = "SELECT * FROM Customer c WHERE c.MOBILE = ?1 AND c.password = ?2 order by custid fetch next 1 row only", nativeQuery = true)
	Customer login(BigInteger mobile, String password);

	/**
	 * 
	 * @param mobile
	 * @return
	 */
	@Query(value = "SELECT * FROM Customer c WHERE c.MOBILE = ?1 order by custid fetch next 1 row only", nativeQuery = true)
	Customer findBymobile(BigInteger mobile);

}
