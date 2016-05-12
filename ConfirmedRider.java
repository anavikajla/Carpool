package in.edu.ashoka;

/**
 * Created by manisha.sah on 12/05/16.
 */

/** The ConfirmRider class give the details of the rider confirmed to a ride. */
public class ConfirmedRider {
    String riderName, riderPhoneNumber, numOfSeatsBooked, deptTime,charges,travelDate, destination;


    /** The constructor stores the details of the rider and the ride.*/
    public ConfirmedRider(String name, String phoneNum, String seatsBooked, String time, String date, String charge, String dest){
        riderName = name;
        riderPhoneNumber = phoneNum;
        numOfSeatsBooked = seatsBooked;
        deptTime = time;
        charges = charge;
        travelDate = date;
        destination = dest;
    }

    // Respective Method returns the respective details of the ride on called.
    public String getRiderName(){return riderName;}
    public String getRiderPhoneNumber(){return riderPhoneNumber;}
    public String getNumOfSeatsBooked(){return numOfSeatsBooked;}
    public String getDeptTime(){return deptTime;}
    public String getCharges(){return charges;}
    public String getTravelDate(){return travelDate;}
    public String getDestination(){return destination;}
}
