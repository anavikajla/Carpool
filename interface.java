/** High Level Design
Ashoka Carpool Program
Anavi Kajla & Manisha Sah
CS205
 

/** This web-app allows the user to offer a ride and request for offered ride if there are any 

available as per the specified date and destination. For now, there are only rides available from campus.*/

/** The Offer class allows user to offer a ride by adding the details of the new ride to the list of offered rides.*/
public class  Offer
{
	/** The method adds the details of a ride to the database.*/
	public static void submit (String offererName,String offererPhoneNumber,String travelDate,String destination,String deptTime,
                               String availableNumberOfSeats,String charges,String description){}
   	
}

/** The Rider class allows the user to view the offered rides.*/
public class Rider
{
    /**The method search the ride from the list of offered rides based on the details of the required ride and returns the list of searched rides*/
    public static List<Ride> searchRides (String travelDate,String destination,String numOfSeatsRequested)
    {}
}

/** The RequestedRide class give the details of the searched/requested ride. */
public class RequestedRide
{
	/** The constructor stores the details of the requested ride.*/
	public RequestedRide(String name, String phoneNum, String availrides, String time, String describe, String id, String charge)
        {}

        // Individual Methods return the respective details of the ride.
        public String getOffererName()
        public String getOffererPhoneNumber()
        public String getAvailableNumOfRides()
        public String getDeptTime()
        public String getDescription()
        public String getRiderId()
        public String getCharges()
}

/** The ConfirmedRide class confirms the selected ride, add the ride details to the list of confirmed list
and give the details of the ride.*/
public class ConfirmRide
{
	/**The method search the details of selected ride, return the present availability of the selected ride and on availability
	 update the list of offered rides and add the ride to the confirmed ride list.*/	
    	public static synchronized int confirm(String id, String riderName, String riderPhoneNumber, String travelDate,String destination,
                                    String numberOfSeatsBooked)
    	{}
    	//Individual methods return the respective details of the ride.
    	public static String getOffererName(){}
    	public static String getOffererPhoneNumber(){}
    	public static String getDeptTime(){}
    	public static String getCharges(){}
    	public static String getDescription(){}
}

/** The SearchConfirmedRider class allows the user to view the list of riders on his/her offered ride.*/
public class SearchConfirmedRiders
{

	 /**The method search the ride from the list of confirmed rides based on the details of the offerer
	 and returns the list of his/her confirmed rider*/
    	public static List<ConfirmedRider> searchRiders (String offererName,String offererPhoneNumber)
    {}
}

/** The ConfirmedRider class give the details of the rider of searched/requested ride. */
public class ConfirmedRider 
{
	/** The constructor stores the details of the rider and ride.*/
	 public ConfirmedRider(String name, String phoneNum, String seatsBooked, String time, String date, String charge, String dest)
    {}
	// Individual methods retuurn the repsective requested details of the rider and ride.
	public String getRiderName(){}
	public String getRiderPhoneNumber(){}
	public String getNumOfSeatsBooked(){}
	public String getDeptTime(){}
	public String getCharges(){}
	public String getTravelDate(){}
	public String getDestination(){}
}
