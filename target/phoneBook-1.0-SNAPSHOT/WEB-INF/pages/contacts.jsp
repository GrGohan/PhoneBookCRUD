<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contacts</title>
</head>
<body>

<h1>Phone Book Contacts</h1>

<form method="GET" action="search">

    <input type="text" name="keyword" />
    <input type="submit" value="Search" />
</form>
<br>
<table border="1" cellpadding="5" bgcolor="#f5f5f5">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>number</th>
    </tr>
    <c:forEach var="contact" items="${contactsList}">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.name}</td>
            <td>${contact.number}</td>
            <td>
                <a href="/edit/${contact.id}">edit</a>
                <a href="/delete/${contact.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>Add Contact</h3>
<c:url value="/add" var="add"/>
<button>
    <a href="${add}">Add new contact</a>
</button>

</body>
</html>
