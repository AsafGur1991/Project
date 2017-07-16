package exceptions;

import java.io.Serializable;

/**
 * 
 * An exception that checks the authorization of the user
 *
 */
public class UnAuthorizedAction extends Exception implements Serializable
{
	/**
	 * Constructs a new exception with null as its detail message
	 */
	public UnAuthorizedAction()
	{

	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message message the detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method.
	 */
	public UnAuthorizedAction(String message)
	{
		super(message);
	}

}
