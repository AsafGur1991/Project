package exceptions;

import java.io.Serializable;

/**
 * 
 * the CustomerExceptionHandler class identify the exception been thrown by a method in the CustomerDBDAO class
 * and resolves it accordingly.
 *
 */
public class CustomerExceptionHandler implements Serializable
{

	/**
	 *   runs the input exception thrown by the customer DBDAO in a switch case method and according to the type of
	 * exception it handles it accordingly
	 * @param e a given exception
	 */
	public static String  customerExceptionHandle(Exception e)
	{
		String exceptions[] = e.getClass().toString().split( "\\." );
		String exceptionClass = exceptions[exceptions.length - 1];
		ExceptionType exceptionType = ExceptionType.valueOf(exceptionClass);
		String resault = null;

		switch(exceptionType)
		{
		case ClassNotFoundException :
			System.out.println(e.getCause());
			resault = "customer class does not exist";
			break;
		case SQLException :
			System.out.println(e.getCause());
			resault = "cannot connect to mysql";   
			break;
		case InterruptedException :
			System.out.println(e.getCause());
			resault = "the thread has been interrupted - the system might be shutting down";
			break;
		case DuplicateEntryException :
			System.out.println(e.getMessage());
			resault = "can't create customer, databease already contains this customer";
			break;
		case WrongDataInputException :
			System.out.println(e.getMessage());
			resault = "either the customer name or the password is wrong - can't login!";
			break;
		case DuplicateCouponTypeException :
			System.out.println(e.getMessage());
			resault = "can't purchase coupon - same coupon type already exist!";
			break;
		case UnAvailableCouponException :
			System.out.println(e.getMessage());
			resault = "can't purchase coupon - no more available coupons or coupon is expired";
			break;
		case NullConnectionException :
			System.out.println(e.getMessage());
			resault = "your connection is null - the system might be shutting down!";
		case WrongEntryException :
			System.out.println(e.getMessage());
			resault = "a customer by that name does not exist!";

		}
		return resault;
	}

}
