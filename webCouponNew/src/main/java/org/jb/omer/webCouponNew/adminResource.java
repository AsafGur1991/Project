package org.jb.omer.webCouponNew;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import core.Company;
import core.Customer;
import exceptions.CompanyExceptionHandler;
import exceptions.CustomerExceptionHandler;
import exceptions.DuplicateEntryException;
import exceptions.NullConnectionException;
import exceptions.WrongEntryException;
import facade.AdminFacade;


@Path("/admin")
public class adminResource 
{
	@Context HttpServletRequest request;
	@Context	
    private HttpServletResponse response;
	AdminFacade facade = null;
	Gson gson = new Gson();
	
	/**
	 * 	
	 * @param company a company object in json format sent from the client
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either that the company was created, or
	 * why the company could not have been created!
	 */
	@POST
	@Path("/create/company")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response createCompany(Company company)
	{
		facade = (AdminFacade) request.getSession().getAttribute("facade");
		try {
			facade.createCompany(company);
		} catch (ClassNotFoundException | InterruptedException | SQLException | DuplicateEntryException
				| NullConnectionException e) {
		return javax.ws.rs.core.Response.ok(CompanyExceptionHandler.companyExceptionHandler(e)).status(500).build();
		}
		return javax.ws.rs.core.Response.ok(company.getCompName() + " was created").status(200).build(); 
		
	}
	
	/**
	 * 
	 * @param company a company object in json format sent from the client
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either that the company was removed, or
	 * why the company could not have been removed!
	 */
	@POST
	@Path("/remove/company")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response removeCompany(Company company)
	{
		System.out.println(company);
		facade = (AdminFacade) request.getSession().getAttribute("facade");
		try {
			facade.removeCompany(company);
		} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException | WrongEntryException e) {
			return javax.ws.rs.core.Response.ok(CompanyExceptionHandler.companyExceptionHandler(e)).status(500).build();
		}
		return javax.ws.rs.core.Response.ok(company.getCompName() + " was removed").status(200).build();
		
	}
	
	/**
	 * 
	 * @param company a company object in json format sent from the client, with updated
	 * values in email and password.
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either that the company data was updated, or
	 * why the company could not have been updated!
	 */
	@POST
	@Path("/update/company")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response updateCompany(Company company)
	{
		facade = (AdminFacade) request.getSession().getAttribute("facade");
		try {
			facade.updateCompany(company);
		} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException | WrongEntryException e) {
			return javax.ws.rs.core.Response.ok(CompanyExceptionHandler.companyExceptionHandler(e)).status(500).build();
			
		}
		return javax.ws.rs.core.Response.ok(company.getCompName() + " was updated").status(200).build();
		
	}
	
	/**
	 * 
	 * @param id the id of the desired company in the database
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either a company object in json format,
	 * or the reason why the method could not get that company from the database.
	 * @throws IOException
	 */
	@GET
	@Path("/get/company/{id}")
	public javax.ws.rs.core.Response getCompany(@PathParam("id") long id) throws IOException {

		AdminFacade facade = (AdminFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getCompany(id));
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CompanyExceptionHandler.companyExceptionHandler(e)).status(500).build();
				
			}
	
	}
	
	/**
	 * 
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either an array of all
	 * of the companies in the database in json format, or the reason why 
	 * the method could not get the companies from the database.
	 */
	@GET
	@Path("/get/all/company")
	@Produces(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response getAllCompanies()
	{
		AdminFacade facade = (AdminFacade) request.getSession().getAttribute("facade");
		try {
			String resault = gson.toJson(facade.getAllCompanies());
			return javax.ws.rs.core.Response.ok(resault).status(200).build();
		} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
				| ParseException e) {
			CompanyExceptionHandler.companyExceptionHandler(e);
			return javax.ws.rs.core.Response.ok(CompanyExceptionHandler.companyExceptionHandler(e)).status(500).build();
		}
				
	}
	
	/**
	 * 
	 * @param customer a customer object in json format sent from the client
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either that the customer was created, or
	 * why the customer could not have been created!
	 */
	@POST
	@Path("/create/customer")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response createCustomer(Customer customer)
	{
		facade = (AdminFacade) request.getSession().getAttribute("facade");
		try {
			facade.createCustomer(customer);
		} catch (ClassNotFoundException | InterruptedException | SQLException | DuplicateEntryException
				| NullConnectionException e) {
		return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
		}
	    return javax.ws.rs.core.Response.ok(customer.getCustName() + " was created").status(200).build();
		
	}
	
	/**
	 * 
	 * @param customer a customer object in json format sent from the client
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either that the customer was removed, or
	 * why the customer could not have been removed!
	 */
	@POST
	@Path("/remove/customer")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response removeCustomer(Customer customer)
	{
		facade = (AdminFacade) request.getSession().getAttribute("facade");
		try {
			facade.removeCustomer(customer);
			return javax.ws.rs.core.Response.ok(customer.getCustName() + " was removed").status(200).build();
		} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException | WrongEntryException e) {
			return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
		}
		
		
	}
	
	/**
	 * 
	 * @param customer a customer object in json format sent from the client, with updated
	 * values of password.
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either that the customer's data was updated,
	 * or why the customer could not have been updated!
	 */
	@POST
	@Path("/update/customer")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response updateCustomer(Customer customer)
	{
		facade = (AdminFacade) request.getSession().getAttribute("facade");
		try {
			facade.updateCustomer(customer);
			return javax.ws.rs.core.Response.ok(customer.getCustName() + " was updated").status(200).build();
		} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException | WrongEntryException e) {
			return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
			
		}
		
		
	}
	
	/**
	 * 
	 * @param id the id of the desired customer in the database
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either a customer object in json format,
	 * or the reason why the method could not get that customer from the database.
	 */
	@GET
	@Path("/get/customer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response getCustomer(@PathParam("id") long id) {

		AdminFacade facade = (AdminFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getCustomer(id));
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
			}
	}
	
	/**
	 * 
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either an array of all
	 * of the customers in the database in json format, or the reason why 
	 * the method could not get the customers from the database.
	 */
	@GET
	@Path("/get/all/customer")
	@Produces(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response getAllCustomers()
	{
		AdminFacade facade = (AdminFacade) request.getSession().getAttribute("facade");
		try {
			String resault = gson.toJson(facade.getAllCustomer());
			return javax.ws.rs.core.Response.ok(resault).status(200).build();
		} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException e) {
			return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
		}
				
	}

}
