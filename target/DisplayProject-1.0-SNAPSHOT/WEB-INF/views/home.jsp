<%@include file="shared/header.jsp" %>
<h1>Home Page</h1>
<table class="table table-hover">

    <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>EMAIL</th>
            <th>ADDRESS</th>
            <th>STATUS</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="client" items="${requestScope.clients}">
            <tr>
                <td>${client.id}</td>
                <td>${client.name}</td>
                <td>${client.email}</td>
                <td>${client.address}</td>
                <td>
                    <c:if test="${client.status}">
                        <label class="label label-success">Active
                        </c:if>
                        <c:if test="${!client.status}">
                            <label class="label label-danger">Inactive
                            </c:if>        
                            </td>

                            </tr>
                        </c:forEach>
                        </tbody>
                        </table>
                        </div>
                        <%@include file="shared/footer.jsp" %>
