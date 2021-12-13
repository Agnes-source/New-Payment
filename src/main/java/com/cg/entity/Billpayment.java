package com.cg.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table
@Entity
public class Billpayment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_beneficiary")
	@SequenceGenerator(name = "seq_billpayment", sequenceName = "seq_billpayment", allocationSize = 1)
	protected int bill_id;

	@Column
	protected String btype;
	@Column
	protected int customer_id;
	@Column
	protected Date ddate;
	@Column
	protected double amount;

	public Billpayment() {

	}

	/**
	 * 
	 * @param bill_id
	 * @param btype
	 * @param customer_id
	 * @param ddate
	 * @param amount
	 */

	public Billpayment(int bill_id, String btype, int customer_id, Date ddate, double amount) {
		super();
		this.bill_id = bill_id;
		this.btype = btype;
		this.customer_id = customer_id;
		this.ddate = ddate;
		this.amount = amount;
	}

	/**
	 * 
	 * @return
	 */

	public int getBill_id() {
		return bill_id;
	}

	/**
	 * 
	 * @param bill_id
	 */

	public void setBill_id(int bill_id) {
		this.bill_id = bill_id;
	}

	/**
	 * 
	 * @return
	 */

	public String getBtype() {
		return btype;
	}

	/**
	 * 
	 * @param btype
	 */

	public void setBtype(String btype) {
		this.btype = btype;
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

	public Date getDdate() {
		return ddate;
	}

	/**
	 * 
	 * @param ddate
	 */

	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}

	/**
	 * 
	 * @return
	 */

	public double getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param amount
	 */

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Billpayment [bill_id=" + bill_id + ", btype=" + btype + ", customer_id=" + customer_id + ", ddate="
				+ ddate + ", amount=" + amount + "]";
	}

}
