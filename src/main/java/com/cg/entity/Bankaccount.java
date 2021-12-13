package com.cg.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author eelangov
 *
 */

@Table
@Entity
public class Bankaccount {
	@Id
	protected BigInteger accountno;
	@Column
	protected String ifsccode;
	@Column
	protected String bankname;
	@Column
	protected int customer_id;
	@Column
	protected double balance;
	
	Bankaccount() {

	}

	/**
	 * 
	 * @param accountno
	 * @param ifsccode
	 * @param bankname
	 * @param customer_id
	 * @param balance
	 */
	public Bankaccount(BigInteger accountno, String ifsccode, String bankname, int customer_id, double balance) {
		super();
		this.accountno = accountno;
		this.ifsccode = ifsccode;
		this.bankname = bankname;
		this.customer_id = customer_id;
		this.balance = balance;
	}
	  
	 /**
	  * 
	  * @return
	  */
	public BigInteger getAccountno() {
		return accountno;
	}
	 /**
	  * 
	  * @param accountno
	  */
	public void setAccountno(BigInteger accountno) {
		this.accountno = accountno;
	}
	/**
	 * 
	 * @return
	 */
	

	public String getIfsccode() {
		return ifsccode;
	}
	/**
	 * 
	 * @param ifsccode
	 */
	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	/**
	 * 
	 * @return
	 */
	public String getBankname() {
		return bankname;
	}

	/**
	 * 
	 * @param bankname
	 */
	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
	/**
	 * 
	 * @return
	 */

	public int getCustomer_id() {
		return customer_id;
	}
	/**
	 * 
	 * @param customer_id
	 */

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	/**
	 * 
	 * @return
	 */

	public double getBalance() {
		return balance;
	}
	/**
	 * 
	 * @param balance
	 */

	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	@Override
	public String toString() {
		return "Bankaccount [accountno=" + accountno + ", ifsccode=" + ifsccode + ", bankname=" + bankname
				+ ", customer_id=" + customer_id + ", balance=" + balance + "]";
	}

}
