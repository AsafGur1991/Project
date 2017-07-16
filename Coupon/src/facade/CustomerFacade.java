package facade;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import core.ClientType;
import core.Coupon;
import core.CouponType;
import dao.CouponDBDAO;
import dao.CustomerDBDAO;
import exceptions.CouponExceptionHandler;
import exceptions.CustomerExceptionHandler;
import exceptions.DuplicateCouponTypeException;
import exceptions.NullConnectionException;
import exceptions.UnAvailableCouponException;
import exceptions.WrongDataInputException;

/**
 * 
 * The CustomerFacade class is used by the customer users of the couponsystem.
 * It grants them access to all of the relevant methods for their uses.
 *
 */
public class CustomerFacade implements CouponClientFacade, Serializable
{

	private CustomerDBDAO customerdbdao;
	private CouponDBDAO  coupondbdao;
	private ArrayList<Coupon> allCoupons = new ArrayList<>();

	/**
	 * the constructor of the CustomerFacade
	 * it initialize the customerdbdao and the coupondbdao
	 */
	public CustomerFacade()
	{
		this.customerdbdao = new CustomerDBDAO();
		this.coupondbdao = new CouponDBDAO();

	}

	/**
	 * Receives a coupon instance and updates it's purchase in the database
	 * @param coupon a coupon instance
	 * @throws NullConnectionException 
	 * @throws UnAvailableCouponException 
	 * @throws DuplicateCouponTypeException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public void purchaseCoupon(Coupon coupon) throws ClassNotFoundException, InterruptedException, SQLException, ParseException, DuplicateCouponTypeException, UnAvailableCouponException, NullConnectionException
	{	
		customerdbdao.purchaseCoupon(coupon);	
	}

	/**
	 * returns an ArrayList of all the current customer's purchased coupons
	 * @return an ArrayList of all the current customer's purchased coupons
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Coupon> getAllPurchasedCoupons() throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException
	{
		allCoupons = (ArrayList<Coupon>) customerdbdao.getCoupons();

		return allCoupons;

	}

	/**
	 * returns an ArrayList of all the current customer's purchased coupons of a given type
	 * @param coupontype a coupon type
	 * @return returns an ArrayList of all the current customer's purchased coupons of a given type
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Coupon> getAllPurchasedCouponsByType(CouponType coupontype) throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException
	{
		allCoupons = customerdbdao.getAllPurchasedCouponsByType(coupontype);

		return allCoupons;

	}

	/**
	 * returns an ArrayList of all the current customer's purchased coupons with a price up to a given price
	 * @param price the max price of a coupon
	 * @return an ArrayList of all the current customer's purchased coupons with a price up to a given price
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Coupon> getAllPurchasedCouponsByPrice(double price) throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException
	{
		allCoupons = customerdbdao.getAllPurchasedCouponsByPrice(price);

		return allCoupons;

	}

	/**
	 * checks the database for a customer entry with the given name and the given password
	 * returns true if it found one, returns false if there is no such entry in the database
	 * @throws NullConnectionException 
	 * @throws WrongDataInputException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	@Override
	public boolean login(String name, String password, ClientType clientType) throws ClassNotFoundException, InterruptedException, SQLException, WrongDataInputException, NullConnectionException
	{	
		return customerdbdao.login(name, password);

	}


	/**
	 * returns a coupon instance of the given id from the database
	 * @param id a coupon's id
	 * @return a coupon instance of the given id from the database
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Coupon getCoupon(long id) throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException
	{
		Coupon coup = new Coupon();
		coup = coupondbdao.getCoupon(id);

		return coup;
	}

	/**
	 * returns an ArrayList of all the coupons in the database
	 * @return an ArrayList of all the coupons in the database
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Coupon> getAllCoupons() throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException
	{
		allCoupons = (ArrayList<Coupon>) coupondbdao.getAllCoupon();

		return allCoupons;
	}
}



