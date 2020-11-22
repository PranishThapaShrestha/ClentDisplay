<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Login</h1>
</div>
<form method="post">
    <div class="form-group">
        <label>User Name</label>
        <input type="text" name="username" class="form-control" required/>
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="password" name="password" class="form-contol" required/>
    </div>
    <button type="submit" class="btn btn-success">Login</button>
</form>

<%@include file="../shared/footer.jsp" %>
