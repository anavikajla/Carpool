<%--
  Created by IntelliJ IDEA.
  User: anavikajla
  Date: 23/04/16
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Page</title>
    <link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="stylesheet.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
<div id="header">
    <p id="write">CarPool</p>
</div>

<div class="row">

<a href="OfferForm.jsp">
    <div class="options col-md-6 btn btn-default">
        <p class="subhead">Offer a Ride</p>
    </div>
</a>



<a href="BookRide.jsp">
    <div class="options col-md-6 btn btn-default">
      <p class="subhead">Book a Ride</p>
    </div>
</a>

    <div class="row">
        <a href="CheckRiders.jsp">
            <div class="options col-md-6 btn btn-default" style="margin-left: 15.5em">
                <p class="subhead">Check your riders</p>
                <p>(for offerers only)</p>
            </div>
        </a>
    </div>

</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>

</body>
</html>
