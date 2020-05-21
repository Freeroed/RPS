<%-- 
    Document   : index
    Created on : 21.05.2020, 9:52:51
    Author     : Freeroed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Test transact</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>Select test</div>
        <div>
            <table border="2">
                <tr>
                    <th>
                        <p><a href="testController?test=success">Test success transact</a></p>
                    </th>
                    <th>
                        <p><a href="testController?test=Rollback">Test rollback transact</a></p>
                    </th>
                    <th>
                        <p><a href="testController?test=Exception">Test Throw Exceprion</a></p>
                    </th>
                    <th>
  
                        <p><a href="testController?test=NoTransact">Test No transact insert in first table</a></p>
                    </th>
                    <th>
  
                        <p><a href="testController?test=NewTransact">Test new transact insert</a></p>
                    </th>
                </tr>
            </table>
        </div>
    </body>
</html>
