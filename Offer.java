package in.edu.ashoka;
import com.mongodb.*;
import java.lang.*;

public class  Offer{

    /** The method will store the inputs from offerer and add on the list of offered rides.*/

    public static void submit (String offerer,String phnNumber,String travelDate,String destination,String deptTime,
                               String numOfSeats,String charged,String description)
    {
        MongoClient user = new MongoClient();
        DB db = user.getDB("Carpool");
        DBCollection rides = db.getCollection("rides");

        BasicDBObject info = new BasicDBObject();
        info.put("Name", offerer.toLowerCase());
        info.put("Phone Number", phnNumber);
        info.put("Travelling Date",travelDate);
        info.put("Destination", destination.toLowerCase());
        info.put("Departure time", deptTime);
        info.put("Available Number of Seats", numOfSeats);
        info.put("Charges", charged);
        info.put("Description",description);

        rides.insert(info);

    }

}