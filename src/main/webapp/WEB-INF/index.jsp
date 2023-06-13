<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Ninja Money Making Game</title>
</head>
<body>
    <h1>Ninja Money Making Game</h1>
    <p>Your Gold: ${gold}</p>
    <h2>Activities:</h2>
    <ul>
        <c:forEach var="activity" items="${activities}">
            <li>${activity}</li>
        </c:forEach>
    </ul>
    <h2>Places to Visit:</h2>
    <form action="/ninja/farm" method="post">
        <button type="submit">Farm</button>
    </form>
    <form action="/ninja/cave" method="post">
        <button type="submit">Cave</button>
    </form>
    <form action="/ninja/house" method="post">
        <button type="submit">House</button>
    </form>
    <form action="/ninja/quest" method="post">
        <button type="submit">Quest</button>
    </form>
    <form action="/ninja/spa" method="post">
        <button type="submit">Spa</button>
    </form>
</body>
</html>
