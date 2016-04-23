/** High Level Design
Ashoka Carpool Program
Anavi Kajla & Manisha Sah
CS205
 b)Interface
 */
import java.util.*;
import java.lang.*;
import com.mongodb.*;

/** This interface will allow the user to offer a ride and request for offered ride if there are any 

available as per the specified date and destination.*/

public class Carpool
{
	
	public static void main(String args[])
	{
		User u = new User();
        	u.user();
        }

}

/** User class will present the different functions(options) offered by the program and direct to them as per the choices of the user.
It will take the name of the user from the login or signUp methods to develop the individual user’s information.
*/

class User
{
	public static void user() 
	{ 
		System.out.println("Name?");
		Scanner inp = new Scanner(System.in);
	        String name = inp.nextLine();
	
	        Offer a = new Offer();
	        a.offer(name);
		//Rider r = new Rider(); // If the users wants to request a ride 
	}
}

 /** Offer class will allow the user to add (i.e. offer) a new ride by specifying the details of the 

ride and confirming it.*/   

class Offer
{
	static String offerer;
	static String travelDate;
	static String destination;
	static String deptTime;
	static String numOfSeats;
	static String charged;	

    /** This method will take inputs from the offerer about the ride. */
	
	public static void offer(String name)
	{	
	    System.out.println ("     Hello"+ " "+ name);

            offerer=name;

            System.out.println("Travelling Date (dd/mm/yy)?");
            Scanner date = new Scanner(System.in);
            travelDate = date.nextLine();

            System.out.println("Destination?");
            Scanner dst = new Scanner(System.in);
            destination = dst.nextLine();

            System.out.println("Departue time (00:00/24 hrs format)?");
            Scanner time = new Scanner(System.in);
            deptTime = time.nextLine();

            System.out.println("Maximum no. of Riders?");
            Scanner seats = new Scanner(System.in);
            numOfSeats = seats.nextLine();

            System.out.println("Charged (Y/N)?");
            Scanner chrg= new Scanner(System.in);
            charged = chrg.nextLine();

            submit();	

	}

	/** The method will store the inputs from offerer and add on the list of offered rides.*/ 
		
	public static void submit ()
	{
	    MongoClient offer = new MongoClient();
            DB db = offer.getDB("offer");
            DBCollection adder = db.getCollection("adder");
            BasicDBObject info = new BasicDBObject();
            info.put("Name", offerer);
            info.put("Travelling Date",travelDate);
            info.put("Destination", destination);
            info.put("Departure time", deptTime);
            info.put("Maximum number of riders", numOfSeats);
            info.put("Charged", charged);

            adder.insert(info);
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

	public static void submit ()
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
