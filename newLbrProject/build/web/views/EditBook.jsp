<%-- 
    Document   : EditBook
    Created on : 03.05.2020, 14:16:56
    Author     : Freeroed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EditBook</title>
    </head>
    <body>
        <h1>Edit Book</h1>
        <form action="EditBook" method="POST">
            <table align="left">
                <input hidden value="${book.id}"
                <tr>
                    <td>Name of book</td>
                    <td>
                        <input type="text" required name="name" value="${book.name}"/>
                    </td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td>
                        <input type="text" required name="genre" value="${book.genre}"/>
                    </td>
                </tr>
                <tr>
                    <td>Author ${book.authorId.fio}</td>
                    <td>
                        <select name="author">
                            <c:forEach items="${authors}" var="author">
                                <option value="${author.id}">${author.fio}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
    </body>
</html>
