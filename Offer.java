package in.edu.ashoka;
import com.mongodb.*;
import java.lang.*;

/** The Offer class allows user to offer a ride by adding the details of the new ride to the list of offered rides.*/
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

}
