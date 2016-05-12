package in.edu.ashoka;
import com.mongodb.*;
import org.bson.types.ObjectId;
import java.lang.*;

/**
 * Created by manisha.sah on 07-05-2016.
 */


/** The ConfirmBookedRide class confirms the selected ride, add the ride details to the list of confirmed list of rides
and give the details of the ride.*/
public class ConfirmBookedRide {

    static String offererName, offererPhoneNumber, availableNumberOfSeats,deptTime,description, charges;


    /**The method search the details of selected ride, return the present availability of the selected ride and on availability
     update the list of offered rides and add the ride to the confirmed ride list. It is accessible to only one user at a time.*/
    public static synchronized int confirm(String id, String riderName, String riderPhoneNumber, String travelDate,String destination,
                                            String numberOfSeatsBooked)
    {
        int count=0;            //count to check whether the ride is still available.

        MongoClient user = new MongoClient();            //connects to the mongodb server
        DB db = user.getDB("Carpool");                  //creates/uses a "carpool" database to store the values.
        DBCollection rides = db.getCollection("rides");          //creates/uses a "rides" collection to store the values.

        BasicDBObject searchQuery = new BasicDBObject();    //ceates a new object to perform search.

        //puts detail of the ride (unique id), which is used to perform the search, into the object under specific headings used in the database.
        searchQuery.put("_id", new ObjectId(id));       

        DBCursor cursor = rides.find(searchQuery);          //perform search based on the details in the "searchquery" object. 
        DBObject rideInfo;

        //gets information about the searched ride from the collection. It is assured that there is only one object found since a single booking is allowed per request.
        while (cursor.hasNext())
        {
            rideInfo = cursor.next();
            offererName = rideInfo.get("Name").toString();
            offererPhoneNumber = rideInfo.get("Phone Number").toString();
            availableNumberOfSeats = rideInfo.get("Available Number of Seats").toString();
            deptTime = rideInfo.get("Departure time").toString();
            description = rideInfo.get("Description").toString();
            charges = rideInfo.get("Charges").toString();
        }

        //changes string to integer.
        int availableNumOfSeatsInt = Integer.parseInt(availableNumberOfSeats);      
        int numberOfSeatsBookedInt = Integer.parseInt(numberOfSeatsBooked);

        if (availableNumOfSeatsInt >= numberOfSeatsBookedInt) // compares whether the ride is still available on the basis of num of seats requested and available seats.
        {
            Integer updateSeats = availableNumOfSeatsInt - numberOfSeatsBookedInt;      //changes to object

            BasicDBObject updateQuery = new BasicDBObject();            ////ceates a new object to update on booking.
            updateQuery.put("$set", new BasicDBObject().append("Available Number of Seats", updateSeats.toString()));     //add detail to be update under the heading.  

            BasicDBObject search = new BasicDBObject();     
            search.put("_id", new ObjectId(id));        //search for the ride to be updated based on its unique id.

            rides.update(search, updateQuery);      //updates the detail under the given heading.
            count++;

            DBCollection confirmRides = db.getCollection("ConfirmedRides");     //creates/uses a "ConfirmedRides" collection to store rides on confirmation.


            //puts the details under specific headings in the collection.    
            BasicDBObject info = new BasicDBObject();
            info.put("Offerer Name", offererName);
            info.put("Offerer Phone Number", offererPhoneNumber);
            info.put("Travelling Date",travelDate);
            info.put("Destination", destination.toLowerCase());
            info.put("Departure time", deptTime);
            info.put("Number of Seats Booked", numberOfSeatsBooked);
            info.put("Charges", charges);
            info.put("Description",description);
            info.put("Rider Name",riderName.toLowerCase());
            info.put("Rider Phone Number",riderPhoneNumber);

            confirmRides.insert(info);       //inserts all the details in the collection.

        }
        return count;   //if count=1, the requested ride is confirmed. if count=0, requested ride has already been taken
    }

    // Respective Method returns the respective details of the ride on called.
    public static String getOffererName(){return offererName;}
    public static String getOffererPhoneNumber(){return offererPhoneNumber;}
    public static String getDeptTime(){return deptTime;}
    public static String getCharges(){return charges;}
    public static String getDescription(){return description;}
}
