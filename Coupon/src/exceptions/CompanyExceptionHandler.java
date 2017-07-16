package exceptions;

import java.io.Serializable;

/**
 * 
 * the CompanyExceptionHandler class identify the exception been thrown by a method in the CompanyDBDAO class
 * and resolves it accordingly.
 *
 */
public class CompanyExceptionHandler implements Serializable
{

	/**
	 * runs the input exception thrown by the company DBDAO in a switch case method and according to the type of
	 * exception it handles it accordingly
	 * @param e a given exception
	 */
	public static String companyExceptionHandler(Exception e)
	{
		String exceptions[] = e.getClass().toString().split( "\\." );
		String exceptionClass = exceptions[exceptions.length - 1];
		ExceptionType exceptionType = ExceptionType.valueOf(exceptionClass);
		String resault = null;

		switch(exceptionType)
		{
		case ClassNotFoundException :
			System.out.println(e.getCause());
			resault = "company class does not exist";
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
			resault = "can't create company, databease already contains this company's name";
			break;
		case WrongDataInputException :
			System.out.println(e.getMessage());
			resault =  "either the company name or the password is wrong - can't login!";
			break;
		case NullConnectionException :
			System.out.println(e.getMessage());
			resault = "your connection is null - the system might be shutting down!";
			break;
		case WrongEntryException :
			System.out.println(e.getMessage());
			resault = "a company by that name does not exist!";
			break;
		case UnAuthorizedAction :
			System.out.println(e.getMessage());
			resault = "you are not authorized for this action";
			break;


		}
		return resault;
	}

}