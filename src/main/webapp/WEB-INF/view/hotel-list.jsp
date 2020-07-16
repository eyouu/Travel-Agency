<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <title>Home Page</title>
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
                <a class="nav-item nav-link active"
                   href="${pageContext.request.contextPath}/management/home">Management</a>
            </security:authorize>
            <div class="username">
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
    <div>
        <form:form cssClass="form-inline" action="searchHotel" method="get">
            <div class="input-group">
                <input class="form-control mr-sm-2" placeholder="Search by Country" type="search"
                       name="countryName"/>
                <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
            </div>
        </form:form>
    </div>
    <hr>
    <div>
        <span class="text">Search Room for period:</span>
        <hr>
        <form:form cssClass="form-inline my-2 my-lg-0 m-auto" action="availableByDate" method="get">
            <div class="input-group">
                <input class="mr-sm-2" type="date" name="checkIn"/>
                <input class="mr-sm-2" type="date" name="checkOut"/>
                <button class="btn btn-success my-2 my-sm-0" type="submit">Search</button>
            </div>
        </form:form>
    </div>

    <hr>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Country</th>
            <th>City</th>
            <th>Action</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="tempRoom" items="${hotelList}">
            <c:url var="showRoomsLink" value="/room/showRooms">
                <c:param name="hotelId" value="${tempRoom.id}"/>
            </c:url>
            <c:url var="addRoomLink" value="/room/addRoom">
                <c:param name="hotelId" value="${tempRoom.id}"/>
            </c:url>
            <tr>
                <td>${tempRoom.id}</td>
                <td>${tempRoom.name}</td>
                <td>${tempRoom.country}</td>
                <td>${tempRoom.city}</td>
                <td>
                    <a class="btn btn-info" href="${showRoomsLink}">Show Rooms</a>
                    <security:authorize access="hasRole('MANAGER')">
                        <a class="btn btn-info" href="${addRoomLink}">Add Room</a>
                    </security:authorize>
                </td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>

</html>