<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<head>
    <title>Rooms</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>

<body>
<div class="container">
    <nav class="navbar navbar-expand-lg sticky-top navbar-dark bg-primary">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/hotel/list">Home</a>
        <div class="navbar-nav">
            <security:authorize access="hasRole('MANAGER')">
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/management/home">Management</a>
            </security:authorize>
            <div class="usernameWS">
                <security:authentication property="principal.username"/>
            </div>
            <div>
                <form:form cssClass="ml-2" action="${pageContext.request.contextPath}/logout" method="post">
                    <input class="btn btn-danger ml-2" type="submit" value="Logout">
                </form:form>
            </div>
        </div>
    </nav>
    <br>
    <h2>Rooms For All Hotels</h2>
    <hr>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/hotel/list">Back</a>
    <br>
    <br>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Room number</th>
            <th>Hotel</th>
            <th>Country</th>
            <th>City</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="tempRoom" items="${rooms}">
            <c:url var="bookRoomLink" value="/room/bookRoom">
                <c:param name="roomId" value="${tempRoom.id}"/>
            </c:url>
            <tr>
                <td>${tempRoom.roomNumber}</td>
                <td>${tempRoom.hotel.name}</td>
                <td>${tempRoom.hotel.country}</td>
                <td>${tempRoom.hotel.city}</td>
                <td>${tempRoom.price}</td>
                <td>
                    <a class="btn btn-info" href="${bookRoomLink}">Book a room</a>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>

</html>