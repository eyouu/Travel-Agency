<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
<head>
    <title>Book a Room</title>
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
    <form:form action="${pageContext.request.contextPath}/room/saveRoomBook" modelAttribute="order" method="post">
        <form:hidden path="id"/>
        <br>
        <h3>Book a Room for hotel: ${order.room.hotel.name}</h3>
        <hr>
        <label>User ID</label>
        <div class="form-inline">
            <form:input cssClass="form-control mb-4 col-4 mr-2" value="${order.user.id}" readonly="true"
                        path="user.id"/>
        </div>
        <label>Username</label>
        <div class="form-inline">
            <input class="form-control mb-4 col-4 mr-2" value="${order.user.username}" readonly="readonly" />
        </div>
        <label>Check In</label>
        <div class="form-inline">
            <form:input cssClass="form-control mb-4 col-4 mr-2" type="date" path="checkIn"/>
            <form:errors cssClass="error" path="checkIn" />
        </div>

        <label>Check Out</label>
        <div class="form-inline">
            <form:input cssClass="form-control mb-4 col-4 mr-2" type="date" path="checkOut"/>
            <form:errors cssClass="error" path="checkOut" />
        </div>

        <label>Room Id</label>
        <div class="form-inline">
            <form:input cssClass="form-control mb-4 col-4 mr-2" value="${order.room.id}" readonly="true"
                        path="room.id"/>
        </div>

        <div>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/room/showRooms?hotelId=${order.room.hotel.id}">Back</a>
            <input class="btn btn-primary col-2" type="submit" value="Save"/>
        </div>
    </form:form>
</div>
</body>

</html>