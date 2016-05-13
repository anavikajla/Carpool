<%--
  Created by IntelliJ IDEA.
  User: anavikajla
  Date: 01/05/16
  Time: 2:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.mongodb.*, java.lang.*, in.edu.ashoka.*"
%>
<html>
<head>
    <title>Confirm Booking</title>
    <link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="stylesheet.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>
<div id="header">
    <p><a href="HomePage.jsp">CarPool</a></p>
</div>

<%
    String riderName = (String)session.getAttribute("Rider Name");

    String riderPhoneNumber = (String) session.getAttribute("Phone Number");

    String travelDate = (String) session.getAttribute("Date");

    String destination = (String) session.getAttribute("Destination");

    String numberOfSeatsBooked = (String) session.getAttribute("Number of Seats Booked");

    String id = request.getParameter("id");


    int ifBooked = ConfirmBookedRide.confirm(id, riderName, riderPhoneNumber,travelDate,destination,numberOfSeatsBooked);

    if(ifBooked == 0){
%>
    <h1>Sorry, ride has been booked up :(</h1>

<%
    }

   else if(ifBooked == 1){
%>
    <h3 style="text-align: center">You have successfully booked a ride!</h3>
    <p style="text-align: center">Your details are below:</p>
<%
    }
    String offererName = ConfirmBookedRide.getOffererName();
    String offererPhoneNumber = ConfirmBookedRide.getOffererPhoneNumber();
    String deptTime = ConfirmBookedRide.getDeptTime();
    String charges = ConfirmBookedRide.getCharges();
    String description = ConfirmBookedRide.getDescription();
%>

<div class="display">
    <p><strong>Your name:</strong><%="  " + riderName%></p>
    <p><strong>Phone Number:</strong><%="  " + riderPhoneNumber%></p>
    <p><strong>Date of Departure:</strong><%="  " + travelDate%></p>
    <p><strong>Destination:</strong><%="  " + destination%></p>
    <p><strong>Number of Seats Booked:</strong><%="  " + numberOfSeatsBooked%></p>
    <p><strong>Your ride offerer's name:</strong><%="  " + offererName%></p>
    <p><strong>Your ride offerer's phone number:</strong><%="  " + offererPhoneNumber%></p>
    <p><strong>Departure Time:</strong><%="  " + deptTime%></p>
    <p><strong>Charges:</strong><%="  " + charges%></p>
    <p><strong>Description:</strong><%="  " + description%></p>
</div>

</body>
</html>