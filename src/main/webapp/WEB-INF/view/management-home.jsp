<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <title>Management</title>
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
    <div >
        <security:authorize access="hasRole('MANAGER')">
            <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/hotel/saveHotelForm">Add New Hotel</a>
        </security:authorize>

        <security:authorize access="hasRole('MANAGER')">
            <a class="btn btn-secondary btn-lg active" href="${pageContext.request.contextPath}/management/showUsers">Show All Users</a>
        </security:authorize>
    </div>
    <br>
    <br>
    <br>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/hotel/list">Back</a>

</div>
</body>

</html>