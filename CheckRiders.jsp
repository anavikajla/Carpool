<%--
  Created by IntelliJ IDEA.
  User: anavikajla
  Date: 12/05/16
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check Riders</title>
    <link type="text/css" rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="stylesheet.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<div id="header">
    <p><a href="HomePage.jsp">CarPool</a></p>
</div>

<form name="checkridersform" method="post" action="ListOfRiders.jsp">

    <div class="form-group">
        <label for="offerer">Name</label>
        <input type="text" name = "offererName" class="form-control" id="offerer" required >
    </div>

    <div class="form-group">
        <label for="phoneNumber">Phone Number</label>
        <input type="number" name="phoneNumber" class="form-control" id="phoneNumber" required>
    </div>

    <div class="form-group" style="padding-top:0.5em"><button type="submit" class="btn btn-default">Submit</button></div>

</form>



</body>
</html>
