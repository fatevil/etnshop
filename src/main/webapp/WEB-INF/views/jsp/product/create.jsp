
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>etnShop</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss" />
    <spring:url value="/resources/core/css/bootstrap.min.css"
                var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
</head>

<div class="container">
    <h2>Create Product</h2>
    <form:form method="post" action="somepage" commandName="somedata">
        <table>
            <tr>
                <td>name</td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>age</td>
                <!--Notice, this is normal html tag, will not be bound to an object -->
                <td><input name="age" type="text"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="send"/>
                </td>
            </tr>
        </table>
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
            var="bootstrapJs" />

<script src="${bootstrapJs}"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>