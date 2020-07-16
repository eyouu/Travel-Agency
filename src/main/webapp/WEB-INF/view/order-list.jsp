<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <title>Orders</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>

<body>
<div class="container">
    <nav class="navbar navbar-expand-lg sticky-top navbar-dark bg-primary">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/hotel/list">Home</a>
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/management/home">Management</a>
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
    <h2>Orders</h2>
    <hr>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/management/showUsers">Back</a>
    <br>
    <br>
    <table class="table table-bordered">
        <thead class="thead-dark">
        <tr>
            <th>Order ID</th>
            <th>User ID</th>
            <th>Check In Date</th>
            <th>Check Out Date</th>
            <th>Room ID</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="tempOrder" items="${orders}">
            <tr>
                <td>${tempOrder.id}</td>
                <td>${tempOrder.user.id}</td>
                <td>${tempOrder.checkIn}</td>
                <td>${tempOrder.checkOut}</td>
                <td>${tempOrder.room.id}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
</div>
</body>

</html>