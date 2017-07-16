package core;

import java.io.Serializable;
import java.util.Collection;

/**
 * 
 * The customer class - holds all the members and constructors of the customers.
 *
 */
public class Customer implements Serializable {

	private long id;
	private String custName;
	private String password;
	private Collection<Coupon> mycoupons;
	
	public Customer()
	{
		
	}
	
	/**
	 * the constructor of the customer class
	 * @param id the id of the customer in the database
	 * @param custName the name of the customer
	 * @param password the password of this customer - used for logging in
	 */

	public Customer(long id, String custName, String password)
	{
		this.id = id;
		this.custName = custName;
		this.password = password;
	}

	/**
	 * return the customer's id
	 * @return the customer's id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * sets the customer's id
	 * @param id the customer's id
	 */
	public void setId(long id) 
	{
		this.id = id;
	}

	/**
	 * return the customer's name
	 * @return the customer's name
	 */
	public String getCustName()
	{
		return custName;
	}

	/**
	 * sets the customer's name
	 * @param custName the customer's name
	 */
	public void setCustName(String custName)
	{
		this.custName = custName;
	}

	/**
	 * return the customer's password
	 * @return the customer's password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * sets the customer's password
	 * @param password the customer's password, used for logging in
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * return the customer's list of created coupons
	 * @return the customer's list of created coupons
	 */
	public Collection<Coupon> getMycoupons() {
		return mycoupons;
	}

	/**
	 * ets the company's list of coupons
	 * @param mycoupons the customers's list of created coupons
	 */
	public void setMycoupons(Collection<Coupon> mycoupons) {
		this.mycoupons = mycoupons;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password + ", mycoupons=" + mycoupons
				+ "]";
	}

	

}