package com.cg.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Billpayment;
import com.cg.entity.Wallet;

@Repository
public interface BillpaymentRepo extends JpaRepository<Billpayment, Integer> {

}
