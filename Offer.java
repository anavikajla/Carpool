package in.edu.ashoka;
import com.mongodb.*;
import java.lang.*;

/** The Offer class allows user to offer a ride by adding the details of the new ride to the list of offered rides and check riders on his/her ride.*/
public class  Offer{


    /** The method adds the details of a ride to the database. It takes input/details about the ride from the user.*/

    public static void submit (String offererName,String offererPhoneNumber,String travelDate,String destination,String deptTime,
                               String availableNumberOfSeats,String charges,String description)
    {
        MongoClient user = new MongoClient();          //connects to the mongodb server
        DB db = user.getDB("Carpool");                      //creates/uses a "carpool" database to store the values.
        DBCollection rides = db.getCollection("rides");         //creates/uses a "rides" collection to store the values.


        //puts the details under specific headings in the collection.
        BasicDBObject info = new BasicDBObject();               
        info.put("Name", offererName.toLowerCase());
        info.put("Phone Number", offererPhoneNumber);
        info.put("Travelling Date",travelDate);
        info.put("Destination", destination.toLowerCase());
        info.put("Departure time", deptTime);
        info.put("Available Number of Seats", availableNumberOfSeats);
        info.put("Charges", charges);
        info.put("Description",description);

        rides.insert(info);             //inserts all the details in the collection.
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
