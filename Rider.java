package in.edu.ashoka;
import com.mongodb.*;
import java.lang.*;
import java.util.*;

/** The Rider class allows the user to view the offered rides or the confirmed rides based on their requirements/need
and returns the list of his/her requested ride or confirmed ride**/
public class Rider
{
    
    /**The method search the ride from the list of offered rides based on the details of the required ride and returns the list of searched rides*/
    public static List<RequestedRide> searchRides (String travelDate, String destination, String numOfSeatsRequested)
    {
        MongoClient user = new MongoClient();       // connects to the mongodb server
        DB db = user.getDB("Carpool");              //creates/uses a "carpool" database to store the values.
        DBCollection rides = db.getCollection("rides");      //creates/uses a "rides" collection to store the values.

        BasicDBObject searchQuery = new BasicDBObject();        //ceates a new object to perform search.


        //puts the detail of the required ride into the object under specific headings used in the database.
        searchQuery.put("Travelling Date", travelDate);
        searchQuery.put("Destination", destination.toLowerCase());
        searchQuery.put("Available Number of Seats", new BasicDBObject("$gte", numOfSeatsRequested));       // available number of seats greater or equal to number of seats requested.

        DBCursor find = rides.find(searchQuery);    //perform search based on the details in the "searchquery" object. 
        DBObject rideInfo;

        List<RequestedRide> listOfSearchedRides = new ArrayList<>();        //creates a list of object "RequestRide"


        //gets information about the searched ride from the collection one at a time and add the ride to the list.
        while (find.hasNext())
        { 
            rideInfo = find.next();
            
            String offererName = rideInfo.get("Name").toString(); 
            String offererPhoneNumber = rideInfo.get("Phone Number").toString();
            String availableNumberOfSeats = rideInfo.get("Available Number of Seats").toString();
            String deptTime = rideInfo.get("Departure time").toString();
            String description = rideInfo.get("Description").toString();
            String riderId = rideInfo.get("_id").toString();
            String charges = rideInfo.get("Charges").toString();

            RequestedRide a = new RequestedRide(offererName, offererPhoneNumber, availableNumberOfSeats, deptTime, description, riderId, charges); //create a ride object with given arguments.
            listOfSearchedRides.add(a);  //adds "a" ride object to the list of searched rides.
        }
        return listOfSearchedRides;         

    }
    
    /**The method search the ride from the list of confirmed rides based on the details of the offerer
     and returns the list of his/her confirmed rider*/
    public static List<ConfirmedRider> searchRiders (String offererName,String offererPhoneNumber)
    {
        MongoClient user = new MongoClient();        //connects to the mongodb server.
        DB db = user.getDB("Carpool");            //creates/uses a "carpool" database to store the values.  
        DBCollection confirmRides = db.getCollection("ConfirmedRides");          //creates/uses a "rides" collection to store the values.

        BasicDBObject searchQuery = new BasicDBObject();    //ceates a new object to perform search.


        //puts the detail of the required ride into the object under specific headings used in the database.
        searchQuery.put("Offerer Name", offererName.toLowerCase());
        searchQuery.put("Offerer Phone Number", offererPhoneNumber);

        DBCursor find = confirmRides.find(searchQuery);         //perform search based on the details in the "searchquery" object.
        DBObject rideInfo;

        List<ConfirmedRider> listOfRiders = new ArrayList<>();      //creates a list of object "RequestRide"


        //gets information about the searched ride from the collection one at a time and add the ride to the list.
        while (find.hasNext())
        {
            rideInfo = find.next();
            String riderName = rideInfo.get("Rider Name").toString();
            String riderPhoneNumber = rideInfo.get("Rider Phone Number").toString();
            String numOfSeatsBooked = rideInfo.get("Number of Seats Booked").toString();
            String deptTime = rideInfo.get("Departure time").toString();
            String travelDate = rideInfo.get("Travelling Date").toString();
            String charges = rideInfo.get("Charges").toString();
            String destination  = rideInfo.get("Destination").toString();

            ConfirmedRider a = new ConfirmedRider(riderName, riderPhoneNumber, numOfSeatsBooked, deptTime,travelDate, charges,destination); ////create a confirmed rider object with given arguments.
            listOfRiders.add(a);        // //adds "a" ride object to the list of searched rides.
        }
        return listOfRiders;

    }
}
