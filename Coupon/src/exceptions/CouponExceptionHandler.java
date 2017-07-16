package exceptions;

import java.io.Serializable;

/**
 * 
 * the CouponExceptionHandler class identify the exception been thrown by a method in the CouponDBDAO class
 * and resolves it accordingly.
 *
 */
public class CouponExceptionHandler implements Serializable
{

	/**
	 *  runs the input exception thrown by the coupon DBDAO in a switch case method and according to the type of
	 * exception it handles it accordingly
	 * @param e a given exception
	 */
	public static String couponExceptionHandle(Exception e)
	{
		String exceptions[] = e.getClass().toString().split( "\\." );
		String exceptionClass = exceptions[exceptions.length - 1];
		ExceptionType exceptionType = ExceptionType.valueOf(exceptionClass);
		String resault = null;

		switch(exceptionType)
		{
		case ClassNotFoundException :
			System.out.println(e.getCause());
			resault = "coupon class does not exist";
			break;
		case SQLException :
			System.out.println(e.getCause());
			resault  = "cannot connect to mysql";
			break;
		case InterruptedException :
			System.out.println(e.getCause());
			resault = "the thread has been interrupted - the system might be shutting down";
			break;
		case ParseException :
			System.out.println(e.getCause());
			resault = "the date has been entered in the wrong format" + " enter the date in the yy-mm-dd format";
			break;
		case DuplicateEntryException :
			System.out.println(e.getMessage());
			resault = "can't create coupon - another coupon with same title alreay exist!";
			break;
		case NullConnectionException :
			System.out.println(e.getMessage());
			resault = "your connection is null - the system might be shutting down!";
		case WrongEntryException :
			System.out.println(e.getMessage());
			resault = "a coupon by that name does not exist!";
		case UnAuthorizedAction :
			System.out.println(e.getMessage());
			resault = "you are not authorized for this action";
		}
		return resault;
	}

}
