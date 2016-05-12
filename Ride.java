package in.edu.ashoka;
import java.lang.*;

/**
 * Created by anavikajla on 07/05/16.
 */
public class Ride
{
        String offererName, offererPhoneNumber, availableNumOfRides, deptTime, description, riderId, charged;

        public Ride(String oName, String oPhone, String availrides, String time, String describe, String id, String charge){ //changed
            offererName = oName;
            offererPhoneNumber = oPhone;
            availableNumOfRides = availrides;
            deptTime = time;
            description = describe;
            riderId = id;
            charged = charge;
        }

        public String getOffererName(){return offererName;}
        public String getOffererPhoneNumber(){return offererPhoneNumber;}
        public String getAvailableNumOfRides(){return availableNumOfRides;} //changed
        public String getDeptTime(){return deptTime;}
        public String getDescription(){return description;}
        public String getRiderId(){return riderId;}
        public String getCharges(){return charged;}
}
