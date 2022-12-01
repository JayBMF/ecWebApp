<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:main>
    <jsp:body>
        <form method="post">
            <div class="card">
                <h5 class="card-header">New Category</h5>
                <div class="card-body">
                    <div class="form-group">
                        <label for="txtCatName">Category</label>
                        <input type="text" class="form-control" id="txtCatName" placeholder="Laptop">
                    </div>
                </div>
                <div class="card-footer text-muted">

                </div>
            </div>
        </form>
    </jsp:body>
</t:main>

