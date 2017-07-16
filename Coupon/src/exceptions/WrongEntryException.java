package exceptions;

import java.io.Serializable;

/**
 * 
 * An exception that provides information on an entry that does not exist
 *
 */
public class WrongEntryException extends Exception implements Serializable
{
	/**
	 * Constructs a new exception with null as its detail message
	 */
	public WrongEntryException()
	{

	}

	/**
	 * Constructs a new exception with the specified detail message.
	 * @param message message the detail message. The detail message is saved for later retrieval by the Throwable.getMessage() method.
	 */
	public WrongEntryException(String message)
	{
		super(message);
	}

}
