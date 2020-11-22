<%@include file="../../shared/header.jsp" %>
<div>
    <h1>Create Contact</h1>
</div>
<form method="post" action="${SITE_URL}/admin/contacts">
    <div class="form-group">
        <label>Name:</label>
        <input type="text" name="name" class="form-contol" required/>
    </div>

    <div class="form-group">
        <label>Email:</label>
        <input type="email" name="email" class="form-contol" required/>
    </div>
 <button type="submit" class="btn btn-success">Send</button>
 <a href="${SITE_URL}/admin/contacts" class="btn btn-danger">Back</a>
</form>
<%@include file="../../shared/footer.jsp" %>