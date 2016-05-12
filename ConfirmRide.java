package in.edu.ashoka;
import com.mongodb.*;
import org.bson.types.ObjectId;
import java.lang.*;

/**
 * Created by manisha.sah on 07-05-2016.
 */

public class ConfirmRide{

    static String offerer, offererPhoneNumber, availableNumOfSeats ,deptTime,description, charges;

    public static int confirm(String id, String riderName, String riderPhoneNumber, String travelDate,String destination,
                                    String numberOfSeatsBooked)
    {
        int count=0;

        /*String offerer = null;
        String offererPhoneNumber = null;
        String availableNumOfSeats = null;
        String deptTime = null;
        String description = null;
        String charges = null;*/

        MongoClient user = new MongoClient();
        DB db = user.getDB("Carpool");
        DBCollection rides = db.getCollection("rides");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("_id", new ObjectId(id));

        DBCursor cursor = rides.find(searchQuery);
        DBObject rideInfo;


        while (cursor.hasNext())
        {
            rideInfo = cursor.next();
            offerer = rideInfo.get("Name").toString();
            offererPhoneNumber = rideInfo.get("Phone Number").toString();
            availableNumOfSeats = rideInfo.get("Available Number of Seats").toString();
            deptTime = rideInfo.get("Departure time").toString();
            description = rideInfo.get("Description").toString();
            charges = rideInfo.get("Charges").toString();

        }

        int availableNumOfSeatsInt = Integer.parseInt(availableNumOfSeats);
        int numberOfSeatsBookedInt = Integer.parseInt(numberOfSeatsBooked);

        if (availableNumOfSeatsInt >= numberOfSeatsBookedInt) //then do the following else return count=0 and print rides not available for requested num of rides.
        {

            Integer updateSeats = availableNumOfSeatsInt - numberOfSeatsBookedInt;

            BasicDBObject updateQuery = new BasicDBObject();
            updateQuery.put("$set", new BasicDBObject().append("Available Number of Seats", updateSeats.toString()));

            BasicDBObject search = new BasicDBObject();
            search.put("_id", new ObjectId(id));

            rides.update(search, updateQuery);
            count++;


            DBCollection confirmRides = db.getCollection("ConfirmedRides");

            BasicDBObject info = new BasicDBObject();
            info.put("Offerer Name", offerer);
            info.put("Offerer Phone Number", offererPhoneNumber);
            info.put("Travelling Date",travelDate);
            info.put("Destination", destination.toLowerCase());
            info.put("Departure time", deptTime);
            info.put("Number of Seats Booked", numberOfSeatsBooked);
            info.put("Charges", charges);
            info.put("Description",description);
            info.put("Rider Name",riderName.toLowerCase());
            info.put("Rider Phone Number",riderPhoneNumber);

            confirmRides.insert(info);

            getOffererName();
            getOffererPhoneNumber();
            getDeptTime();
            getCharges();
            getDescription();
        }
        return count;   //if count=1, the requested ride is confirmed. if count=0, requested ride is taken away.
    }

    public static String getOffererName(){return offerer;}
    public static String getOffererPhoneNumber(){return offererPhoneNumber;}
    public static String getDeptTime(){return deptTime;}
    public static String getCharges(){return charges;}
    public static String getDescription(){return description;}
}