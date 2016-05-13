<%--
  Created by IntelliJ IDEA.
  User: anavikajla
  Date: 23/04/16
  Time: 10:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="com.mongodb.*"%>
<html>
<head>
    <title>Offer a Ride</title>
    <link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="stylesheet.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div id="header">
    <p><a href="HomePage.jsp">CarPool</a></p>
</div>

<h3 style="text-align: center">Fill in the form below to add your ride!</h3>

<form name="offer_form" method="post" action="ConfirmOffer.jsp">
<div class="form-group">
        <label for="offerer">Name</label>
        <input type="text" name = "offererName" class="form-control" id="offerer" required >
</div>

<div class="form-group">
    <label for="phoneNumber">Phone Number</label>
    <input type="tel" name="phoneNumber" class="form-control" id="phoneNumber" max="10"required>
</div>

<div class="form-group">
    <label for="destination">Destination (please specify a city or a more general location eg. airport. You can be more specific in the description)</label>
    <input type="text" name="destination" class="form-control" id="destination" placeholder="Delhi,Parker,etc." required >
</div>

<div class="form-group">
    <label for="travelDate">Travel Date(DD/MM/YYYY)</label>
    <input type="date" name="travelDate" class="form-control" id="travelDate" required>
</div>

<div class="form-group">
    <label for="deptTime">Departure Time(--:-- PM/AM)</label>
    <input type="time" name="deptTime" class="form-control" id="deptTime" required>
</div>

<div class="form-group">
    <label for="riders">Available Number of Seats in your Ride</label>
    <input type="number" name="riders" class="form-control" id="riders" required>
</div>

    <%--check to keep a bound on description--%>
<div class="form-group">
        <label for="description">Briefly describe your ride</label>
        <input type="text" name="description" class="form-control" id="description" required>
    </div>

<div class ='form-group'>
        <label for="charges">Do you want to charge people for the ride?(yes/no) </label>
        <input type="text" name="charges" class="form-control" id="charges" required>
</div>

<div class="form-group" style="padding-top:0.5em"><button type="submit" class="btn btn-default">Submit</button></div>
</form>


</body>
</html>
