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
                        <input type="text" class="form-control" id="txtCatName" placeholder="Laptop" autofocus>
                    </div>
                </div>
                <div class="card-footer text-muted">
                    <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/Admin/Category/" role="button">
                        <i class="fa fa-backward" aria-hidden="true"></i>
                        Back
                    </a>
                    <button type="submit" class="btn btn-primary">
                        <i class="fa fa-check" aria-hidden="true"></i>
                        Save
                    </button>
                </div>
            </div>
        </form>
    </jsp:body>
</t:main>

