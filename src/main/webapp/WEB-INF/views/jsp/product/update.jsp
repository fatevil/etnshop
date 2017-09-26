<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>etnShop</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>

<div class="container">

    <form:form method="post" action="./" modelAttribute="productForm" class="form-horizontal">
        <h2>Update Product</h2>
        <div class="row">
            <div class="col-sm-4">
                <label class="control-label">Name:</label>
                <form:errors path="name" class="text-danger"/>
                <form:input path="name" class="col-sm-2 form-control"/>

            </div>
        </div>
        <div class="row">
            <div class="col-sm-4">
                <label class="control-label">Serial Number:</label>
                <form:errors path="serialNumber" class="text-danger"/>
                <form:input path="serialNumber" class="col-sm-2 form-control"/>
            </div>
        </div>
        <br>
        <p>
            <form:input type="hidden" path="id" value="${productForm.id}"/>
            <input class="btn btn-secondary" type="submit" value="Submit">
        </p>
    </form:form>

    <hr>
    <p>
        <a class="btn btn-primary btn-lg" href="/etnshop" role="button">Back to homepage</a>
    </p>
    <footer>
        <p>&copy; Etnetera a.s. 2015</p>
    </footer>
</div>

<spring:url value="/resources/core/css/bootstrap.min.js"
            var="bootstrapJs"/>

<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>