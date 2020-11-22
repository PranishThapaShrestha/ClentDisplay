<%@page import="com.dproject.client.entity.Client"%>
<%@page import="com.dproject.client.repository.impl.ClientRepositoryImpl"%>
<%@page import="com.dproject.client.repository.ClientRepository"%>
<%
    if(request.getMethod().equalsIgnoreCase("post")){
        ClientRepository repository= new ClientRepositoryImpl();
       
        Client client= new Client();
       
        client.setName(request.getParameter("username"));
        client.setEmail(request.getParameter("email"));
        client.setAddress(request.getParameter("address"));
        int result=repository.insert(client);
        if (result>0){
            response.sendRedirect("succes.jsp");
        }else{
            response.sendRedirect("register.jsp");
        }
    }else{
        response.sendRedirect("/");
    }
%>  