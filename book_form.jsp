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
    <p id="write">CarPool</p>
</div>

<h3 style="text-align: center">Fill in the form below to book your ride!</h3>

    <div class="form-group">
        <label for="Name">Name</label>
        <input type="text" class="form-control" id="Name">
    </div>

    <div class="form-group">
        <label for="Email">Email address</label>
        <input type="email" class="form-control" id="Email">
    </div>

    <div class="form-group">
        <label for="phone-number">Phone Number</label>
        <input type="number" class="form-control" id="phone-number">
    </div>

    <div class="form-group">
        <label for="destination">Destination</label>
        <input type="text" class="form-control" id="destination" placeholder="Delhi,Parker,etc.">
    </div>

    <div class="form-group">
        <label for="date">Date</label>
        <input type="date" class="form-control" id="date">
    </div>

    <div class="form-group">
        <label for="time">Time</label>
        <input type="time" class="form-control" id="time">
    </div>

    <div class="form-group"><button type="submit" class="btn btn-default">Submit</button></div>

</body>
</html>
