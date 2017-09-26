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
    <h2>Create New Product</h2>
    <form:form method="post" action="./create" modelAttribute="productForm" class="form-horizontal">

        <div class="row">
            <div class="col-sm-4">
                <label class="control-label">Name:</label>
                <form:errors path="name" class="text-danger"/>
                <form:input path="name" class="col-sm-2 form-control" required="required"/>

            </div>
        </div>

        <div class="row">
            <div class="col-sm-4">
                <label class="control-label">Serial Number:</label>
                <form:errors path="serialNumber" class="text-danger"/>
                <form:input path="serialNumber" class="col-sm-2 form-control" required="required" type="number"
                            max="2147483647"/>
            </div>

        </div>
        <br>
        <p>
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