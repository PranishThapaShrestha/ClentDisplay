<%@include file="shared/header.jsp" %>
<div class="page-header">        
    <h1>Contact us!</h1>
</div>
<form action="" method="post" class="page-header container">
    <div class="form-group">
        <label>Name:</label>
        <input type="text" name="name" class="form-contol" required/>
    </div>

    <div class="form-group">
        <label>Email:</label>
        <input type="email" name="email" class="form-contol" required/>
    </div>

    
    <button type="submit" class="btn btn-success">Send</button>
</form>
<%@include file="shared/footer.jsp" %>
