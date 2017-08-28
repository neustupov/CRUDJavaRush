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

<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a href="user.do?page=${currentPage - 1}">Previous</a></td>
</c:if>

<%--For displaying Page numbers.
    The when condition does not display a link for the current page--%>
<table border="1" cellpadding="5" cellspacing="5">
    <tr>
        <c:forEach begin="1" end="${noOfPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <td>${i}</td>
                </c:when>
                <c:otherwise>
                    <td><a href="user.do?page=${i}">${i}</a></td>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </tr>
</table>


<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="user.do?page=${currentPage + 1}">Next</a></td>
</c:if>
</body>
</html>