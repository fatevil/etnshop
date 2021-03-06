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
    <h2>Search for Product</h2>
    <form:form method="post" action="./list/fulltext" class="form-horizontal">

        <div class="row">
            <div class="col-sm-4">
                <label class="control-label">Name:</label>
                <input name="name" class="col-sm-2 form-control"/>
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