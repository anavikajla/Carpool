package in.edu.ashoka;
import java.lang.*;

/**
 * Created by manisha.sah on 07/05/16.
 */


/** The RequestedRide class give the details of the searched/requested ride. */
public class RequestedRide
{
    String offererName, offererPhoneNumber, availableNumOfRides, deptTime, description, riderId, charged;       

    /** The constructor stores the details of the requested ride.*/
    public RequestedRide(String name, String phoneNum, String availrides, String time, String describe, String id, String charge)
    { 
      offererName = name;
      offererPhoneNumber = phoneNum;
      availableNumOfRides = availrides;
      deptTime = time;
      description = describe;
      riderId = id;
      charged = charge;
    }

    // Respective Method returns the respective details of the ride on called.
    public String getOffererName(){return offererName;}
    public String getOffererPhoneNumber(){return offererPhoneNumber;}
    public String getAvailableNumOfRides(){return availableNumOfRides;} 
    public String getDeptTime(){return deptTime;}
    public String getDescription(){return description;}
    public String getRiderId(){return riderId;}
    public String getCharges(){return charged;}
}
