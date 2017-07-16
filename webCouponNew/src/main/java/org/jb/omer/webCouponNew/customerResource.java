package org.jb.omer.webCouponNew;

import java.io.IOException;
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

import core.Coupon;
import core.CouponType;
import exceptions.CouponExceptionHandler;
import exceptions.CustomerExceptionHandler;
import exceptions.DuplicateCouponTypeException;
import exceptions.NullConnectionException;
import exceptions.UnAuthorizedAction;
import exceptions.UnAvailableCouponException;
import exceptions.WrongEntryException;
import facade.CompanyFacade;
import facade.CustomerFacade;

@Path("/customer")
public class customerResource
{
	@Context HttpServletRequest request;
	@Context	
    private HttpServletResponse response;
	CustomerFacade facade = null;
	Gson gson = new Gson();
	
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

		 facade = (CustomerFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getCoupon(id));
				System.out.println(resault);
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
	 * of the coupons in the database in json format, or the reason why 
	 * the method could not get the coupons from the database.
	 * @throws IOException
	 */
	@GET
	@Path("/get/all/coupons")
	public javax.ws.rs.core.Response getAllCoupons() throws IOException {

		 facade =  (CustomerFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getAllCoupons());
				System.out.println(resault);
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
				
			}
	
	}
	
	/**
	 * 
	 * @param coupon a coupon object sent from the client.
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either a message that the coupon
	 * was purchased, or the reason why the method could not purchase the coupons.
	 */
	@POST
	@Path("/purchase/coupon")
	@Consumes(MediaType.APPLICATION_JSON)
	public javax.ws.rs.core.Response purchaseCoupon(Coupon coupon)
	{
		System.out.println(coupon);
		facade =   (CustomerFacade) request.getSession().getAttribute("facade");
		
			try {
				facade.purchaseCoupon(coupon);
			} catch (ClassNotFoundException | InterruptedException | SQLException | ParseException
					| DuplicateCouponTypeException | UnAvailableCouponException | NullConnectionException e) {
				return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
			}		
		return javax.ws.rs.core.Response.ok(coupon.getTitle() + " was purchased!").status(200).build();
		
	}
	
	/**
	 * 
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either an array of all
	 * of the customer's purchased coupons in the database in json format, or the reason why 
	 * the method could not get the coupons from the database.
	 * @throws IOException
	 */
	@GET
	@Path("/get/all/purchased/coupons")
	public javax.ws.rs.core.Response getAllPurchasedCoupons() throws IOException {

		 facade =  (CustomerFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getAllPurchasedCoupons());
				System.out.println(resault);
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
				
			}
	
	}
	
	/**
	 * 
	 * @param couponType the couponType of the desired purchased coupons in the database
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either an array of all
	 * of the customer's purchased coupons in the database of the given couponType in json 
	 * format or, the reason why the method could not get the coupons from the database.
	 * @throws IOException
	 */
	@GET
	@Path("/get/all/purchased/coupons/type/{couponType}")
	public javax.ws.rs.core.Response getAllPurchasedCouponsByType(@PathParam("couponType") CouponType couponType) throws IOException {

		 facade = (CustomerFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getAllPurchasedCouponsByType(couponType));
				System.out.println(resault);
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
				
			}
	
	}
	
	/**
	 * 
	 * @param price the max price of the desired purchased coupons in the database
	 * @return a response with a status code and the correct response
	 * according to the outcome of the method - either an array of all
	 * of the customer's purchased coupons in the database with a price up to the given price
	 * in json format, or the reason why the method could not get the coupons from
	 * the database.
	 * @throws IOException
	 */
	@GET
	@Path("/get/all/purchased/coupons/price/{price}")
	public javax.ws.rs.core.Response getAllPurchasedCouponsByPrice(@PathParam("price") double price) throws IOException {

		 facade = (CustomerFacade) request.getSession().getAttribute("facade");
			try {
				String resault = gson.toJson(facade.getAllPurchasedCouponsByPrice(price));
				System.out.println(resault);
				return javax.ws.rs.core.Response.ok(resault).status(200).build();
			} catch (ClassNotFoundException | InterruptedException | SQLException | NullConnectionException
					| ParseException e) {
				return javax.ws.rs.core.Response.ok(CustomerExceptionHandler.customerExceptionHandle(e)).status(500).build();
				
			}
	
	}

}
