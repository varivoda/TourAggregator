<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 13.04.16
  Time: 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transportation</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css"/>
</head>
<body class="main" background="../../images/bg/bg3.jpg">

<div class="center">

    <ul>
        <li><a href="../../client/personalArea.jspx">Main</a></li>
        <li><a href="DescriptionTransportation.jsp">Transportation</a></li>
        <li><a href="../tour/DescriptionHotel.jsp">Hotel</a></li>
        <li><a href="DescriptionRentCar.jsp">Rent car</a></li>
        <li><a href="../ViewMyTour.jspx">View my tour</a></li>
        <li style="float:right" >
            <div>
                <c:out value="${fullName}"/> <br/>
                <form action="/Logout" method="post">
                    <input type="submit" value="exit"/>
                </form>
            </div>
        </li>

    </ul>

    <form class="transportation" action="/FindTransportation" method="post">

        <table>
            <tr>
                <td><label for="pointOfSaleCode">Point of sale code*</label></td>
                <td>
                    <select id="pointOfSaleCode" name="pointOfSaleCode">
                        <option value="US">US</option>
                        <option value="RUS">RUS</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td ><label for="originCode">Origin code*</label></td>

                <td><select id="originCode" name="originCode">
                    <option value="JFK">JFK</option>
                    <option value="LAX">LAX</option>
                </select>
                </td>
            </tr>
            <tr>
                <td> <label for="destinationCode">Destination code*</label></td>

                <td>
                    <select id="destinationCode" name="destinationCode">
                        <option value="JFK">JFK</option>
                        <option value="LAX">LAX</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><label for="departureDate">Departure date*</label></td>
                <td><input type="date" id="departureDate" name="departureDate"/></td>
            </tr>
            <tr>
                <td><label for="lengthOfStay">Days*</label></td>
                <td><input type="number" id="lengthOfStay" name="lengthOfStay" /></td>
            </tr>
            <tr>
                <td><label for="maxFare">Max fare</label></td>
                <td><input type="text" id="maxFare" name="maxFare"></td>
            </tr>

            <tr>
                <td></td>
                <td></td>
            </tr>
        </table>

        <!--<label for=""></label>-->
        <!--<input type="" id="" name="">-->


        <input type="submit" value="Submit"/>
    </form>

</div>


</body>
</html>
