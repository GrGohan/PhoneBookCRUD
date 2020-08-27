<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:choose>
        <c:when test="${empty contact.name}">
            <title>Add</title>
        </c:when>
        <c:otherwise>
            <title>Edit</title>
        </c:otherwise>
    </c:choose>
</head>
<body>
<c:url value="/add" var="addUrl"/>
<c:url value="/edit" var="editUrl"/>
<form action="${empty contact.name ? addUrl : editUrl}" name="contact" method="POST">
    <c:choose>
        <c:when test="${!empty contact.name}">
            <p><h2>Edit Contact</h2></p>
            <input type="hidden" name="id" value="${contact.id}">
        </c:when>
        <c:otherwise>
            <p><h2>Add New Contact</h2></p>
        </c:otherwise>
    </c:choose>
    <p><input type="text" name="name" placeholder="name" value="${contact.name}" maxlength="100" required>
    <p><input type="number" name="number" placeholder="number" value="${contact.number}" required>

    <p>
        <c:set value="add" var="add"/>
        <c:set value="edit" var="edit"/>
        <input type="submit" value="${empty contact.name ? add : edit}">
    </p>

</form>
</body>
</html>