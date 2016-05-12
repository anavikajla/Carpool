package in.edu.ashoka;
import com.mongodb.*;
import java.lang.*;
import java.util.*;

/**
 * Created by anavikajla on 12/05/16.
 */
public class SearchConfirmedRiders {

    public static List<ConfirmedRider> searchRiders (String offererName,String offererPhoneNumber)
    {
        MongoClient user = new MongoClient();
        DB db = user.getDB("Carpool");
        DBCollection confirmRides = db.getCollection("ConfirmedRides");

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("Offerer Name", offererName.toLowerCase());
        searchQuery.put("Offerer Phone Number", offererPhoneNumber);


        DBCursor find = confirmRides.find(searchQuery);
        DBObject rideInfo;

        List<ConfirmedRider> listOfRiders = new ArrayList<>();

        while (find.hasNext()){
            rideInfo = find.next();
            String riderName = rideInfo.get("Rider Name").toString();
            String riderPhoneNumber = rideInfo.get("Rider Phone Number").toString();
            String numOfSeatsBooked = rideInfo.get("Number of Seats Booked").toString();
            String deptTime = rideInfo.get("Departure time").toString();
            String travelDate = rideInfo.get("Travelling Date").toString();
            String charges = rideInfo.get("Charges").toString();
            String destination  = rideInfo.get("Destination").toString();


            ConfirmedRider a = new ConfirmedRider(riderName, riderPhoneNumber, numOfSeatsBooked, deptTime,travelDate, charges,destination); //change name
            listOfRiders.add(a);
        }
        return listOfRiders;

    }
}

