package in.edu.ashoka;
import com.mongodb.*;
import java.lang.*;
import java.util.*;

public class Rider
{
    public static List<Ride> searchRides (String travelDate,String destination,String numOfSeatsRequested)
    {
        MongoClient user = new MongoClient();
        DB db = user.getDB("Carpool");
        DBCollection rides = db.getCollection("rides");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("Travelling Date", travelDate);
        searchQuery.put("Destination", destination.toLowerCase());
        searchQuery.put("Available Number of Seats", new BasicDBObject("$gte", numOfSeatsRequested));

        DBCursor find = rides.find(searchQuery); //changed
        DBObject rideInfo;

        List<Ride> listOfSearchedRides = new ArrayList<>();

        while (find.hasNext()){
            rideInfo = find.next();
            
            String offerer = rideInfo.get("Name").toString(); //change to offererName
            String phoneNumber = rideInfo.get("Phone Number").toString();
            String numOfSeats = rideInfo.get("Available Number of Seats").toString();
            String deptTime = rideInfo.get("Departure time").toString();
            String description = rideInfo.get("Description").toString();
            String riderId = rideInfo.get("_id").toString();
            String charges = rideInfo.get("Charges").toString();

            Ride a = new Ride(offerer, phoneNumber, numOfSeats, deptTime, description, riderId, charges);
            listOfSearchedRides.add(a);
        }
        return listOfSearchedRides;

    }
}