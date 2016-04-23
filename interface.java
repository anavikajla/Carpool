/** High Level Design
Ashoka Carpool Program
Anavi Kajla & Manisha Sah
CS205
 b)Interface
 */
import java.util.*;
import java.lang.*;

/** This interface will allow the user to offer a ride and request for offered ride if there are any 

available as per the specified date and destination.*/

public class Carpool
{
	
	public static void main(String args[])
	{
	
	}

	/* The login method checks whether the user has inputted the correct credentials and 		directs to the user's page where the three options to book, offer or cancel a ride will 		be made available.*/
	
	public static void login()
	{
		/*User u = new User(); 
		u.user(id); //calls user method */
	}

	/*  The signUp method allows the user to create an account, grants access to the 
		program and on completion redirects to the user’s page.*/

	public static void signUp()
	{
		/*User u = new User();
		u.user(id);  //calls user method */
	}
}

/** User class will present the different functions(options) offered by the program and direct to them as per the choices of the user.
It will take the name of the user from the login or signUp methods to develop the individual user’s information.
*/

class User
{
	public static void user(String name) 
	{ 
		Rider r = new Rider(); // If the users wants to request a ride 
	}
}

 /** Offer class will allow the user to add (i.e. offer) a new ride by specifying the details of the 

ride and confirming it.*/   

class Offer
{
	String offerer, travelDate, destination, deptTime, numOfSeats, charged;

    /** This method will take inputs from the offerer about the ride. */
	
	public static void offer(String name)
	{
		
	}

		/** The method will store the inputs from offerer and add on the list of offered 			rides.*/ 
		
	public static void confirm ()
	{
		
	} 
}

/** Rider class will allow the user to access the offered rides and select his preferred one. Only one ride can be selected at once.*/

class Rider
{
	String travelDate, destination, deptTime;
	
	/** The method rider will take inputs from the rider and give the list of available offered 	rides as per specified dates and destination.*/
	
	public static void rider(String name)
	{
	
	}

/** The method confirm will accept the select ride and update the list of offered rides.*/

	public static void confirm ()
	{
	
	}
}

/** Destination class will take the location. */

class Destination
{
	String location; 
	
	/** The method confirm will take the destination from the user.*/
	public void Destination (String destination)
	{
		
	}
}
