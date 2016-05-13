<%--
  Created by IntelliJ IDEA.
  User: anavikajla
  Date: 30/04/16
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="com.mongodb.*, java.lang.*,java.util.*"  %>
<%@ page import="in.edu.ashoka.*" %>
<html>
<head>
    <title>Search Results</title>
    <link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="stylesheet.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<div id="header">
    <p><a href="HomePage.jsp">CarPool</a></p>
</div>

<%

    String rider = request.getParameter("riderName");
    session.setAttribute("Rider Name", rider);

    //for use later
    String phoneNumber = request.getParameter("phoneNumber");
    session.setAttribute("Phone Number", phoneNumber);

    String travelDate = request.getParameter("travelDate");
    session.setAttribute("Date", travelDate);

    String destination = request.getParameter("destination");
    session.setAttribute("Destination", destination);

    String numberOfSeatsRequested = request.getParameter("numberOfSeats");
    session.setAttribute("Number of Seats Booked", numberOfSeatsRequested);

    List<RequestedRide> listOfRides = Rider.searchRides(travelDate, destination,numberOfSeatsRequested);
%>

<p class="text-center" style="color: darkgray; font-size: 2em">search results for:<%="  "+ destination%> on <%=travelDate%></p>

<table class="table table-hover table-responsive table-striped">
    <tr>
        <th style="width: 15%;font-size: 1em">Name</th>
        <th style="width: 15%;font-size: 1em">Phone Number</th>
        <th style="width: 13%;font-size: 1em">Seats Available</th>
        <th style="width: 12%;font-size: 1em">Departure Time</th>
        <th style="width: 28%;font-size: 1em">Description</th>
        <th style="width: 7%;font-size: 1em">Charged?</th>
        <th style="width: 10%;font-size: 1em">Book it!</th>

    </tr>
<%
    int a = listOfRides.size();
    if (a==0)
    {
%>
    <h4>Sorry, no rides found :(</h4>
    <%
        }
        else{
    for(int i=0;i<a;i++)
    {
        RequestedRide ride = (RequestedRide) listOfRides.get(i);

        String offererName = ride.getOffererName();
        String PhoneNumber = ride.getOffererPhoneNumber();
        String availableNumRides = ride.getAvailableNumOfRides();
        String time = ride.getDeptTime();
        String description = ride.getDescription();
        String id = ride.getRiderId();
        String charge = ride.getCharges();
%>

   <tr>
    <td><%=offererName%></td>
    <td><%=PhoneNumber%></td>
    <td><%=availableNumRides%></td>
    <td><%=time%></td>
    <td><%=description%></td>
    <td><%=charge%></td>
    <td>
       <form method="post" action="ConfirmBooking.jsp">
           <input type="hidden" name="id" value="<%=id%>" >
           <input type="hidden" name="phoneNumber" value="<%=PhoneNumber%>">
           <button type="submit" class="btn btn-primary" onclick="book(this)">Book</button>
       </form>
    </td>
   </tr>

<%
    }
    }
%>


</table>
<%--<% //jam the data-id field of the clicked button into the method parameter rideId
  document.getElementByID("offererID").value=element.getAttribute("data-id");}
%> --%>

</body>
</html>
