package com.cg.entity;

import java.beans.JavaBean;
import java.math.BigInteger;

@JavaBean
public class Userprofile {

	private String name;
	private BigInteger mobile;
	private String password;
	private String ifsccode;
	private BigInteger accountno;
	private String bankName;
	private int balance;

	/**
	 * 
	 * @return
	 */

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return
	 */

	public BigInteger getMobile() {
		return mobile;
	}

	/**
	 * 
	 * @param mobile
	 */

	public void setMobile(BigInteger mobile) {
		this.mobile = mobile;
	}

	/**
	 * 
	 * @return
	 */

	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 */

	public void setPassword(String password) {
		this.password = password;
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

	public String getBankName() {
		return bankName;
	}

	/**
	 * 
	 * @param bankName
	 */

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * 
	 * @return
	 */

	public int getBalance() {
		return balance;
	}

	/**
	 * 
	 * @param balance
	 */

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Userprofile [name=" + name + ", mobile=" + mobile + ", password=" + password + ", ifsccode=" + ifsccode
				+ ", accountno=" + accountno + ", bankName=" + bankName + ", balance=" + balance + "]";
	}

}
