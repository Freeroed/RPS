<%-- 
    Document   : CreateBook
    Created on : 03.05.2020, 13:08:43
    Author     : Freeroed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating book</title>
    </head>
    <body>
        <h1>Create new book</h1>
        <form action="CreateBook" method="POST">
            <table align="left">
                <tr>
                    <td>Name of book</td>
                    <td>
                        <input type="text" required name="name"/>
                    </td>
                </tr>
                <tr>
                    <td>Genre</td>
                    <td>
                        <input type="text" required name="genre"
                    </td>
                </tr>
                <tr>
                    <td>Author</td>
                    <td>
                        <select name="author">
                            <c:forEach items="${authors}" var="author">
                                <option value="${author.id}">${author.fio}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </table>
            <input required type="submit" value="SAVE"/>
        </form>
    </body>
</html>
