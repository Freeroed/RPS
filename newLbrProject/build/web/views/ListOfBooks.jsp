<%-- 
    Document   : ListOfBooks
    Created on : 03.05.2020, 12:43:41
    Author     : Freeroed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books</title>
    </head>
    <body>
        <h1>This is list of books
        <form action = "CreateBook" method="get">
            <input type="submit" value="Create new book">
        </form></h1>
        <table align="left" style="border-spacing: 30px 11px;" >
            <tr>
                <th>Name of book</th>
                <th>Genre</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td>${book.name}</td>
                    <td>${book.genre}</td>
                    <td><form action="ListOfBooks" method="post">
                            <input type="hidden" name="id" value="${book.id}">
                            <input type="submit" value="delete"> </form>
            </td>
            <td>
                <form action="EditBook" method="get">
                            <input type="hidden" name="id" value="${book.id}">
                            <input type="submit" value="Edit">
                </form>
            </td>
                </tr>
            </c:forEach>
        
        </table>
    </body>
</html>
