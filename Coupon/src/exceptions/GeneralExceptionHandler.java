package exceptions;

import java.io.Serializable;

/**
 * 
 * the GeneralExceptionHandler class identify the exception been thrown by a method in any of the DBDAO classes
 * and resolves it accordingly.
 * it is used for methods been called by a non-user class (i.e automated class/threads). 
 *
 */
public class GeneralExceptionHandler implements Serializable
{

	/**
	 * runs the input exception thrown in a switch case method and according to the type of
	 * exception it handles it accordingly
	 * @param e a given exception
	 */
	public static String generalExceptionHandle(Exception e)
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
			resault = "cannot connect to mysql";
			break;
		case InterruptedException :
			System.out.println(e.getCause());
			resault = "the thread has been interrupted - the system might be shutting down";
			break;
		case ParseException :
			System.out.println(e.getCause());
			resault = "the date has been entered in the wrong format" + "enter the date in the yy-mm-dd format";
			break;
		case NullConnectionException :
			System.out.println(e.getMessage());
			resault = "your connection is null - the system might be shutting down!";
			break;
		case WrongDataInputException :
			System.out.println(e.getMessage());
			resault =  "either the user name or the password is wrong - can't login!";
			break;
		}
		return resault;
	}

}


