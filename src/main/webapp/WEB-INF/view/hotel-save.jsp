<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!DOCTYPE html>

<html>
<head>
    <title>Save new Hotel</title>
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
    <h2>Save new hotel</h2>
    <hr>
    <form:form action="${pageContext.request.contextPath}/hotel/saveHotel" modelAttribute="hotel" method="post">
        <form:hidden path="id" />

        <label>Hotel name</label>
        <div class="form-inline">
            <form:input cssClass="form-control mb-4 col-4 mr-2" placeholder="Hotel name" path="name" />
            <form:errors cssClass="error" path="name" />
        </div>

        <label>Country</label>
        <div class="form-inline">
            <form:input cssClass="form-control mb-4 col-4 mr-2" placeholder="Country" path="country" />
            <form:errors cssClass="error" path="country" />
        </div>

        <label>City</label>
        <div class="form-inline">
            <form:input cssClass="form-control mb-4 col-4 mr-2" placeholder="City" path="city" />
            <form:errors cssClass="error" path="city" />
        </div>

        <div>
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/management/home">Back</a>
            <input class="btn btn-primary col-2" type="submit" value="Save"/>
        </div>
    </form:form>
</div>
</body>

</html>