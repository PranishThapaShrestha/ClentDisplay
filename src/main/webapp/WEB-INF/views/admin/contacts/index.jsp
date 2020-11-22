<%@include file="../../shared/header.jsp" %>
<div class="page-header">
    <h1>Contacts</h1>
</div>
<div class="pull-right">
    <p>
        <a href="${SITE_URL}/admin/contacts/create" class="btn btn-primary btn-xs">
            <span class="glyphicon glyphicon-plus"></span>
            Add
        </a>
    </p>
</div>
<table class="table table-hover">

    <thead>
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>EMAIL</th>
            <th>CREATED</th>
            <th>STATUS</th>
            <th>ACTION</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="contact" items="${contacts}">
            <tr>
                <td>${contact.id}</td>
                <td>${contact.name}</td>
                <td>${contact.email}</td>
                <td>${contact.created}</td>
                <td>
                    <c:if test="${contact.status}">
                        <label class="label label-success">Active
                        </c:if>
                        <c:if test="${!contact.status}">
                            <label class="label label-danger">Inactive
                            </c:if>        
                            </td>
                            <td>
                                <a href="${SITE_URL}/admin/contacts/edit/?id=${contact.id}" class="btn btn-warning btn-xs">
                                     <span class="glyphicon glyphicon-plus"></span>
                                    Edit
                                </a>
                                <a href="${SITE_URL}/admin/contacts/delete/?id=${contact.id}" onclick="return confirm('Are you sure to delete ?')" class="btn btn-danger btn-xs">
                                     <span class="glyphicon glyphicon-trash"></span>
                                    Delete
                                </a>
                            </td>

                            </tr>
                        </c:forEach>
                        </tbody>
                        </table>
                        </div>
                        <%@include file="../../shared/footer.jsp" %>
