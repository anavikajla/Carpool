<%--
  Created by IntelliJ IDEA.
  User: anavikajla
  Date: 23/04/16
  Time: 10:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book a Ride</title>
    <link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="stylesheet.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div id="header">
    <p><a href="HomePage.jsp">CarPool</a></p>
</div>

<h3 style="text-align: center">Fill in the form below to book your ride!</h3>

<form name="book_form" method="post" action="ListOfOfferedRides.jsp">
    <div class="form-group">
        <label for="rider">Name</label>
        <input type="text" name = "riderName" class="form-control" id="rider" required>
    </div>

    <div class="form-group">
        <label for="phoneNumber">Phone Number</label>
        <input type="tel" name = "phoneNumber" class="form-control" id="phoneNumber" max="10" required>
    </div>

    <div class="form-group">
        <label for="destination">Destination</label>
        <input type="text" name = "destination" class="form-control" id="destination" placeholder="Delhi,Parker,etc." required>
    </div>

    <div class="form-group">
        <label for="travelDate">Travel Date</label>
        <input type="date" name = "travelDate" class="form-control" id="travelDate"required>
    </div>


    <div class="form-group">
        <label for="numberOfSeats">Number of Seats you want to book</label>
        <input type="number" name = "numberOfSeats" class="form-control" id="numberOfSeats" required>
    </div>


    <div class="form-group submit"><button type="submit" class="btn btn-default">Search</button></div>

</body>
</html>