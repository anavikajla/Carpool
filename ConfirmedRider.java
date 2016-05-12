package in.edu.ashoka;

/**
 * Created by anavikajla on 12/05/16.
 */
public class ConfirmedRider {
    String riderName, riderPhoneNumber, numOfSeatsBooked, deptTime,charges,travelDate, destination;

    public ConfirmedRider(String name, String phone, String seatsBooked, String time, String date, String charge, String dest){
        riderName = name;
        riderPhoneNumber = phone;
        numOfSeatsBooked = seatsBooked;
        deptTime = time;
        charges = charge;
        travelDate = date;
        destination = dest;
    }

    public String getRiderName(){return riderName;}
    public String getRiderPhoneNumber(){return riderPhoneNumber;}
    public String getNumOfSeatsBooked(){return numOfSeatsBooked;} //changed
    public String getDeptTime(){return deptTime;}
    public String getCharges(){return charges;}
    public String getTravelDate(){return travelDate;}
    public String getDestination(){return destination;}
}
