<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<jsp:useBean id="category" scope="request" type="com.example.ecwebapp.beans.Category"/>

<t:main>
  <jsp:body>
    <form method="post">
      <div class="card">
        <h5 class="card-header">
          Category
        </h5>
        <div class="card-body">
          <div class="form-group">
            <label for="txtCatID">#</label>
            <input type="text" class="form-control" id="txtCatID" placeholder="Laptop" name="CatID" readonly value="${category.catID}">
          </div>
          <div class="form-group">
            <label for="txtCatName">Category</label>
            <input type="text" class="form-control" id="txtCatName" placeholder="Laptop" name="CatName" autofocus value="${category.catName}">
          </div>
        </div>
        <div class="card-footer text-muted">
          <a class="btn btn-outline-success" href="${pageContext.request.contextPath}/Admin/Category/" role="button">
            <i class="fa fa-backward" aria-hidden="true"></i>
            Back
          </a>
          <button type="submit" class="btn btn-danger">
            <i class="fa fa-trash-o" aria-hidden="true"></i>
            Delete
          </button>
          <button type="submit" class="btn btn-primary">
            <i class="fa fa-check" aria-hidden="true"></i>
            Save
          </button>
        </div>
      </div>
    </form>
  </jsp:body>
</t:main>

