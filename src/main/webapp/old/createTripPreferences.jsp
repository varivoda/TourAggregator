<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 23.11.15
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Creating the trip preferences</title>
</head>
<body>
Enter your preferences
<form name="createPreferences" action="" method="post">
    Quantity of travelers: <input name="travelersQuantity" type="number"> <br>
    Budget: <input name="budget" type="number"> <br>
    Date of departure: <input name="departureDate" type="datetime"> <br>
    Date of arrival: <input name="arrivalDate" type="datetime"> <br>
    Kind of transport:
    <select name="TransportKind">
        <option disabled>Check the kind of transport</option>
        <option value="AVTO">Avto</option>
        <option value="LANE">Plane</option>
        <option value="BUS">Bus </option>
    </select>

</form>
</body>
</html>
