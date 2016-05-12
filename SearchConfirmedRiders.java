package in.edu.ashoka;
import com.mongodb.*;
import java.lang.*;
import java.util.*;

/**
 * Created by manisha.sah on 12/05/16.
 */

/** The SearchConfirmedRider class allows the user to view the list of riders on his/her offered ride. It takes input from the user for now for searching his/her rides.*/
public class SearchConfirmedRiders {

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
        while (find.hasNext()){
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

