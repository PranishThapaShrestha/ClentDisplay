<%-- 
    Document   : reister.jsp
    Created on : Jan 9, 2020, 10:10:42 AM
    Author     : Pranish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Company registration</h1>
        <form method="post" action="_register.jsp">
                
            <div>
                <label>Name:</label>
                <input type="text" name="username" required="" />
            </div>
            <div>
                <label>E-mail:</label>
                <input type="email" name="email" required="" />
               
            </div>
            <div>
                <label>ADDRESS</label>
                <input type="text" name="address" required="" />
               
            </div>
             <button type="submit">Register</button>
        </form>
    </body>
</html>
