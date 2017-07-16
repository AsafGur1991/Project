package facade;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import core.ClientType;
import core.Company;
import core.Coupon;
import core.CouponType;
import dao.CompanyDBDAO;
import dao.CouponDBDAO;
import dao.CustomerDBDAO;
import exceptions.CompanyExceptionHandler;
import exceptions.CouponExceptionHandler;
import exceptions.DuplicateEntryException;
import exceptions.NullConnectionException;
import exceptions.UnAuthorizedAction;
import exceptions.WrongDataInputException;
import exceptions.WrongEntryException;

/**
 * 
 * The CompanyFacade class is used by the company users of the couponsystem.
 * It grants them access to all of the relevant methods for their uses.
 *
 */
public class CompanyFacade implements CouponClientFacade, Serializable
{

	private CompanyDBDAO companydbdao;
	private CouponDBDAO coupondbdao;
	private Coupon myCoupon = new Coupon();
	private Company myCompany = new Company();
	private ArrayList<Coupon> allMyCoupons = new ArrayList<>();


	/**
	 * the CompanyFacade constructor.
	 * it initialize the companydbdao and the coupondbdao
	 */
	public CompanyFacade()
	{
		this.companydbdao = new CompanyDBDAO();
		this.coupondbdao = new CouponDBDAO();	

	}

	/**
	 * Receives a coupon instance and register it in the database
	 * @param coupon a coupon instance
	 * @throws NullConnectionException 
	 * @throws DuplicateEntryException 
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public void createCoupon(Coupon coupon) throws ClassNotFoundException, SQLException, InterruptedException, DuplicateEntryException, NullConnectionException
	{	
		coupondbdao.createCoupon(coupon);	
	}

	/**
	 * Receives a coupon instance and removes its entries from the database
	 * @param coupon a coupon instance
	 * @throws NullConnectionException 
	 * @throws InterruptedException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws WrongEntryException 
	 * @throws UnAuthorizedAction 
	 */
	public void removeCoupon(Coupon coupon) throws ClassNotFoundException, SQLException, InterruptedException, NullConnectionException, WrongEntryException, UnAuthorizedAction
	{
		coupondbdao.removeCoupon(coupon);
	}

	/**
	 * Receives a coupon instance and update its entries in the database
	 * @param coupon a coupon instance
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 * @throws WrongEntryException 
	 * @throws UnAuthorizedAction 
	 */
	public void updateCoupon(Coupon coupon) throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException, WrongEntryException, UnAuthorizedAction
	{
		coupondbdao.updateCoupon(coupon);		
	}

	/**
	 * Receives a coupon' id and return an instance of that coupon from the database
	 * @param id a coupon's id
	 * @return an instance of the desired coupon from the database
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
	 * returns an ArrayList of all the company's coupons in the database
	 * @return an ArrayList of all the company's coupons in the database
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Coupon> getAllCoupon() throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException
	{
		allMyCoupons = (ArrayList<Coupon>) companydbdao.getCoupons();		

		return allMyCoupons;


	}

	/**
	 * returns an ArrayList of all the company's coupons in the database by a given type
	 * @param couponType a coupon type
	 * @return an ArrayList of all the company's coupons in the database by a given type
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Coupon> getCouponByType(CouponType couponType) throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException
	{
		allMyCoupons = (ArrayList<Coupon>) companydbdao.getCompanyCouponByType(couponType);

		return allMyCoupons;
	}

	/**
	 * returns an ArrayList of all the company's coupons in the database with a price up to a given price
	 * @param price the max price of a coupon
	 * @return an ArrayList of all the company's coupons in the database with a price up to a given price
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Coupon> getCouponByPrice(double price) throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException
	{
		allMyCoupons = (ArrayList<Coupon>) companydbdao.getCompanyCouponByPrice(price);

		return allMyCoupons;
	}

	/**
	 * returns an ArrayList of all the company's coupons in the database with an end date up to a given date
	 * @param date a given end date
	 * @return an ArrayList of all the company's coupons in the database with an end date up to a given date
	 * @throws NullConnectionException 
	 * @throws ParseException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Coupon> getCouponByDate (Date date) throws ClassNotFoundException, InterruptedException, SQLException, ParseException, NullConnectionException
	{
		allMyCoupons = (ArrayList<Coupon>) companydbdao.getCompanyCouponByDate(date);

		return allMyCoupons;
	}

	/**
	 * checks the database for a company entry with the given name and the given password
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
		return companydbdao.login(name, password);


	}

	/**
	 * sets the id of the current user in the coupon DBDAO
	 */
	public void setUserId()
	{
		this.coupondbdao.setUserCompanyId(companydbdao.getUserCompanyId());
	}
}
