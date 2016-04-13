<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 13.04.16
  Time: 8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rent car</title>
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
</head>

<body class="body" background="../images/bg/bg3.jpg">

<div class="center">

    <ul>
        <li><a href="../client/personalArea.jspx">Main</a></li>
        <li><a href="../tour/DescriptionTransportation.jsp">Transportation</a></li>
        <li><a href="../tour/DescriptionHotel.jsp">Hotel</a></li>
        <li><a href="../tour/DescriptionRentCar.jsp">Rent car</a></li>
        <li><a href="../tour/ViewMyTour.jspx">View my tour</a></li>
        <li style="float:right" >
            <div>
                <c:out value="${fullName}"/> <br/>
                <form action="/Logout" method="post">
                    <input type="submit" value="exit"/>
                </form>
            </div>
        </li>

    </ul>
</div>

</body></html>
