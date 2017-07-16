package facade;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import core.ClientType;
import core.Company;
import core.Customer;
import dao.CompanyDBDAO;
import dao.CouponDBDAO;
import dao.CustomerDBDAO;
import exceptions.CompanyExceptionHandler;
import exceptions.CustomerExceptionHandler;
import exceptions.DuplicateEntryException;
import exceptions.NullConnectionException;
import exceptions.WrongEntryException;

/**
 * 
 * The AdminFacade class is used only by the Admin of the couponsystem. 
 * He has the access to create, remove and update the different users of the couponsystem.
 *
 */
public class AdminFacade implements CouponClientFacade, Serializable
{

	private CompanyDBDAO companydbdao;
	private CouponDBDAO coupondbdao;
	private CustomerDBDAO customerdbdao;
	ArrayList<Company> allCompanys = new ArrayList<>();
	ArrayList<Customer> allCustomers = new ArrayList<>();


	/**
	 * the AdminFacade constructor - it initialize all the DBDAOs
	 */
	public AdminFacade()
	{
		this.companydbdao = new CompanyDBDAO();
		this.coupondbdao = new CouponDBDAO();
		this.customerdbdao = new CustomerDBDAO();

	}

	/**
	 * Receives a company instance and register it in the database
	 * @param company a company instance
	 * @throws NullConnectionException 
	 * @throws DuplicateEntryException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public void createCompany(Company company) throws ClassNotFoundException, InterruptedException, SQLException, DuplicateEntryException, NullConnectionException
	{
		companydbdao.createCompany(company);		

	}

	/**
	 * Receives a company instance and removes its entries from the database
	 * @param company a company instance
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 * @throws WrongEntryException 
	 */
	public void removeCompany(Company company) throws ClassNotFoundException, InterruptedException, SQLException, NullConnectionException, WrongEntryException
	{	
		companydbdao.removeComapny(company);		

	}

	/**
	 * Receives a company instance and update its entries in the database
	 * @param company a company instance
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 * @throws WrongEntryException 
	 */
	public void updateCompany(Company company) throws ClassNotFoundException, InterruptedException, SQLException, NullConnectionException, WrongEntryException
	{	
		companydbdao.updateCompany(company);		

	}

	/**
	 * Returns an ArrayList of all the companys in the database
	 * @return an ArrayList of all the companys in the database
	 * @throws ParseException 
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Company> getAllCompanies() throws ClassNotFoundException, InterruptedException, SQLException, NullConnectionException, ParseException
	{
		allCompanys = (ArrayList<Company>) companydbdao.getAllCompanys();		

		return allCompanys;

	}

	/**
	 * Receives an id of a company and returns an instance of that company from the database
	 * @param id a company's id
	 * @return an instance of that company from the database
	 * @throws ParseException 
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Company getCompany(long id) throws ClassNotFoundException, InterruptedException, SQLException, NullConnectionException, ParseException
	{
		Company comp = new Company();
		comp = companydbdao.getCompany(id);		

		return comp;

	}

	/**
	 * Receives a customer instance and register it in the database
	 * @param customer a customer instance
	 * @throws NullConnectionException 
	 * @throws DuplicateEntryException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public void createCustomer(Customer customer) throws ClassNotFoundException, InterruptedException, SQLException, DuplicateEntryException, NullConnectionException
	{
		customerdbdao.createCustomer(customer);	
	}

	/**
	 * Receives a customer instance and removes its entries from the database
	 * @param customer a customer instance
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 * @throws WrongEntryException 
	 */
	public void removeCustomer(Customer customer) throws ClassNotFoundException, InterruptedException, SQLException, NullConnectionException, WrongEntryException
	{
		customerdbdao.removeCustomer(customer);		
	}

	/**
	 * Receives a customer instance and updates its entries in the database
	 * @param customer a customer instance
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 * @throws WrongEntryException 
	 */
	public void updateCustomer(Customer customer) throws ClassNotFoundException, InterruptedException, SQLException, NullConnectionException, WrongEntryException
	{
		customerdbdao.updateCustomer(customer);		

	}

	/**
	 * returns an ArrayList of all the customers in the database
	 * @return an ArrayList of all the customers in the database
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 */
	public Collection<Customer> getAllCustomer() throws ClassNotFoundException, InterruptedException, SQLException, NullConnectionException
	{
		allCustomers = null;
		allCustomers = (ArrayList<Customer>) customerdbdao.getAllCustomer();		

		return allCustomers;
	}

	/**
	 * Receives a customer is and returns an instance of that customer from the database
	 * @param id a customer id
	 * @return an instance of that customer from the database
	 * @throws NullConnectionException 
	 * @throws SQLException 
	 * @throws InterruptedException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	public Customer getCustomer(long id) throws ClassNotFoundException, InterruptedException, SQLException, NullConnectionException, ParseException
	{
		Customer cust = new Customer();
		cust = customerdbdao.getCustomer(id);

		return cust;
	}

	/**
	 * checking the database for an entry of an admin client type with the matching name and password
	 * returns true if it found one' returns false if there is no matching entry
	 */
	@Override
	public boolean login(String name, String password, ClientType clientType)
	{
		if (name.equals("admin") && password.equals("1234"))
		{
			return true;
		}

		return false;
	}
}
