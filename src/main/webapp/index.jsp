<%-- 
    Document   : index.jsp
    Created on : Jan 7, 2020, 9:02:14 AM
    Author     : Pranish
--%>
<%@page import="com.dproject.client.service.ClientService"%>
<%@page import="com.dproject.client.service.impl.ClientServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.dproject.client.entity.Client"%>
<%
    ClientService service=new ClientServiceImpl();
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Users!</h1> 
        <select>
            <option value="">Select Clients</option>
            <%
                for(Client client:service.findall()){
            %>
            <option value="<%=client.getId()%>">
            <%=client.getName()%>
            </option>
             <%
             }
             %>    
            
        </select>
        <table border="1">
            
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>EMAIL</th>
                    <th>ADDRESS</th>
                    <th>STATUS</th>
                </tr>
            </thead>
           <%
                for(Client client:service.findall()){
           %>
           <tr>
               <td><%=client.getId()%></td>
               <td><%=client.getName()%></td>
               <td><%=client.getEmail()%></td>
               <td><%=client.getAddress()%></td>
               <td><%=client.isStatus()%></td>
           </tr>
            <%
                }  
            %>
        </table>
        <h2>
            Have not introduced to this yet?
            <a href="register.jsp">Click here to register!!!</a>
        </h2>
    </body>
</html>
