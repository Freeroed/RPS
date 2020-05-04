<%-- 
    Document   : ListOfAuthors
    Created on : 03.05.2020, 12:44:30
    Author     : Freeroed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authors</title>
    </head>
    <body>
        <h1>This is list of authors</h1>
        <table align="left" style="border-spacing: 30px 11px;" >
            <tr>
                <th>FIO</th>
                <th>Country</th>
                <th></th>
            </tr>
            <c:forEach items="${authors}" var="author">
                <tr>
                    <td>${author.fio}</td>
                    <td>${author.country}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
