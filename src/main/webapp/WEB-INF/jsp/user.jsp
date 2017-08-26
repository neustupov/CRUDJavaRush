<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Management</title>
</head>
<body>
<h1>Users Data</h1>
<form:form action="user.do" method="POST" commandName="user">
    <table>
        <tr>
            <td>User ID</td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td>User Name</td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td>User Age</td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td>isAdmin</td>
            <td><form:input path="isAdmin" /></td>
        </tr>
        <tr>
            <td>Date</td>
            <td><form:input path="date" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="action" value="Add" />
                <input type="submit" name="action" value="Edit" />
                <input type="submit" name="action" value="Delete" />
                <input type="submit" name="action" value="Search" />
            </td>
        </tr>
    </table>
</form:form>
<br>
<table border="1">
    <th>ID</th>
    <th>User name</th>
    <th>User Age</th>
    <th>isAdmin</th>
    <th>Date</th>
    <c:forEach items="${usersList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.isAdmin}</td>
            <td>${user.date}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>