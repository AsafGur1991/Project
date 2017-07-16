package org.jb.omer.webCouponNew;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;


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
import core.Coupon;
import core.CouponType;
import exceptions.CompanyExceptionHandler;
import exceptions.CouponExceptionHandler;
import exceptions.DuplicateEntryException;
import exceptions.NullConnectionException;
import exceptions.UnAuthorizedAction;
import exceptions.WrongEntryException;
import facade.AdminFacade;
import facade.CompanyFacade;

@Path("/company")
public class companyResource
{
	
	
	@Context HttpServletRequest request;
	@Context	
    private HttpServletResponse response;
	CompanyFacade facade = null;
	Gson gson = new Gson();
	
	/**
	 * 
	 * @param coupon a coupon object in json format sent from the client
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either that the coupon was created, or
	 * why the coupon could not have been created!
	 */
	@POST
	@Path("/create/coupon")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response createCoupon(Coupon coupon)
	{
		facade =  (CompanyFacade) request.getSession().getAttribute("facade");
		try {
			facade.createCoupon(coupon);
		} catch (ClassNotFoundException | InterruptedException | SQLException | DuplicateEntryException
				| NullConnectionException e) {
		return javax.ws.rs.core.Response.ok(CouponExceptionHandler.couponExceptionHandle(e)).status(500).build();
		}
		return javax.ws.rs.core.Response.ok(coupon.getTitle() + " was created").status(200).build(); 
		
	}
	
	/**
	 * 
	 * @param id the id of the desired coupon in the database
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either a coupon object in json format,
	 * or the reason why the method could not get that coupon from the database.
	 * @throws IOException
	 */
	@GET
	@Path("/get/coupon/{id}")
	public javax.ws.rs.core.Response getCoupon(@PathParam("id") long id) throws IOException {

		 facade = (CompanyFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getCoupon(id));
				System.out.println(resault);
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CouponExceptionHandler.couponExceptionHandle(e)).status(500).build();
				
			}
	
	}
	
	/**
	 * 
	 * @param coupon a coupon object in json format sent from the client
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either that the coupon was removed, or
	 * why the coupon could not have been removed!
	 */
	@POST
	@Path("/remove/coupon")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response removeCoupon(Coupon coupon)
	{
		System.out.println(coupon);
		facade =  (CompanyFacade) request.getSession().getAttribute("facade");
		try {
			facade.removeCoupon(coupon);;
		} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException | WrongEntryException | UnAuthorizedAction e) {
			return javax.ws.rs.core.Response.ok(CouponExceptionHandler.couponExceptionHandle(e)).status(500).build();
		}
		return javax.ws.rs.core.Response.ok(coupon.getTitle() + " was removed").status(200).build();
		
	}
	
	/**
	 * 
	 * @param coupon a coupon object in json format sent from the client, with updated
	 * values of end date and price.
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either that the coupon data was updated, or
	 * why the coupon could not have been updated!
	 */
	@POST
	@Path("/update/coupon")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response updateCoupon(Coupon coupon)
	{
		facade =  (CompanyFacade) request.getSession().getAttribute("facade");
		try {
			facade.updateCoupon(coupon);
		} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException | WrongEntryException | ParseException | UnAuthorizedAction e) {
			return javax.ws.rs.core.Response.ok(CouponExceptionHandler.couponExceptionHandle(e)).status(500).build();
			
		}
		return javax.ws.rs.core.Response.ok(coupon.getTitle() + " was updated").status(200).build();
		
	}
	
	/**
	 * 
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either an array of all
	 * of the coupons in the database in json format, or the reason why 
	 * the method could not get the coupons from the database.
	 * @throws IOException
	 */
	@GET
	@Path("/get/all/coupons")
	public javax.ws.rs.core.Response getAllCoupons() throws IOException {

		 facade = (CompanyFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getAllCoupon());
				System.out.println(resault);
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CouponExceptionHandler.couponExceptionHandle(e)).status(500).build();
				
			}
	
	}
	
	/**
	 * 
	 * @param couponType the couponType of the desired created coupons in the database
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either an array of all
	 * of the company's created coupons in the database of the given couponType in json format, or 
	 * the reason why the method could not get the coupons from the database.
	 * @throws IOException
	 */
	@GET
	@Path("/get/all/coupons/type/{couponType}")
	public javax.ws.rs.core.Response getAllCouponsByType(@PathParam("couponType") CouponType couponType) throws IOException {

		 facade = (CompanyFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getCouponByType(couponType));
				System.out.println(resault);
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CouponExceptionHandler.couponExceptionHandle(e)).status(500).build();
				
			}
	
	}
	
	/**
	 * 
	 * @param price the max price of the desired created coupons in the database
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either an array of all
	 * of the company's created coupons in the database with a price up to the given price
	 * in json format, or the reason why the method could not get the coupons from
	 * the database.
	 * @throws IOException
	 */
	@GET
	@Path("/get/all/coupons/price/{price}")
	public javax.ws.rs.core.Response getAllCouponsByPrice(@PathParam("price") double price) throws IOException {

		 facade = (CompanyFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getCouponByPrice(price));
				System.out.println(resault);
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CouponExceptionHandler.couponExceptionHandle(e)).status(500).build();
				
			}
	
	}
	
	/**
	 * 
	 * @param date the end date of the desired created coupons in the database
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either an array of all
	 * of the company's created coupons in the database with an end date up to the given date
	 * in json format, or the reason why the method could not get the coupons from
	 * the database.
	 * @throws IOException
	 */
	@POST
	@Path("/get/all/coupons/date")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response getAllCouponsByDate(java.util.Date date) throws IOException {
		
		 facade = (CompanyFacade) request.getSession().getAttribute("facade");
			
				String resault;
				try {
					resault = gson.toJson(facade.getCouponByDate(date));
				} catch (ClassNotFoundException | InterruptedException | SQLException | ParseException
						| NullConnectionException e) {
					return javax.ws.rs.core.Response.ok(CompanyExceptionHandler.companyExceptionHandler(e)).status(500).build();
				}
				System.out.println(resault);
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
	
				
			
	
	}

}
