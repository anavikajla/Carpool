<%--
  Created by IntelliJ IDEA.
  User: anavikajla
  Date: 12/05/16
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="in.edu.ashoka.*, java.util.*"%>
<html>
<head>
    <title>List Of Riders</title>
    <link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="stylesheet.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<body>

<div id="header">
    <p><a href="HomePage.jsp">CarPool</a></p>
</div>

<%
String offererName = request.getParameter("offererName");

String offererPhoneNumber = request.getParameter("phoneNumber");

List<ConfirmedRider>listOfRiders = Offer.searchRiders(offererName,offererPhoneNumber);
%>

    <p class="text-center" style="color: darkgray; font-size: 2em">search results for:<%=" " + offererName%></p>

    <table class="table table-hover table-responsive table-striped">
        <tr>
            <th style="width: 20%;font-size: 1em">Riders Name</th>
            <th style="width: 15%;font-size: 1em">Riders Phone Number</th>
            <th style="width: 15%;font-size: 1em">Destination</th>
            <th style="width: 15%; font-size: 1em">Travel Date</th>
            <th style="width: 15%;font-size: 1em">Departure Time</th>
            <th style="width: 10%;font-size: 1em">Seats Booked</th>
            <th style="width: 10%;font-size: 1em">Charges</th>

        </tr>
        <%
            int listSize = listOfRiders.size();
            if(listSize==0){
            %>
                <h4>Sorry, no riders found :(</h4>
            <%
            }

            else{
                for(int i = 0; i< listSize; i++)
                {
                    ConfirmedRider rider = (ConfirmedRider) listOfRiders.get(i);

                    String riderName = rider.getRiderName();
                    String phoneNumber = rider.getRiderPhoneNumber();
                    String numOfSeatsBooked = rider.getNumOfSeatsBooked();
                    String deptTime = rider.getDeptTime();
                    String travelDate = rider.getTravelDate();
                    String charge= rider.getCharges();
                    String destination = rider.getDestination();
             %>

        <tr>
            <td><%=riderName%></td>
            <td><%=phoneNumber%></td>
            <td><%=destination%></td>
            <td><%=travelDate%></td>
            <td><%=deptTime%></td>
            <td><%=numOfSeatsBooked%></td>
            <td><%=charge%></td>
        </tr>

                <%
                 }
            }
             %>
    </table>
</body>
</html>
