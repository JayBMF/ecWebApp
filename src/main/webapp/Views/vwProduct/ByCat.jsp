<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<jsp:useBean id="products" scope="request" type="java.util.List<com.example.ecwebapp.beans.Product>"/>

<t:main>
  <jsp:body>
    <div class="card">
      <h4 class="card-header">
        Products
      </h4>
      <c:choose>
        <c:when test="${products.size()==0}">
          <div class="card-body">
            <p class="card-text">Không có dữ liệu</p>
          </div>
        </c:when>
        <c:otherwise>
          <div class="card-body">
            <div class="row">
              <c:forEach items="${products}" var="p">
                <div class="col-sm-4 mb-3">
                  <div class="card h-100">
                    <img src="${pageContext.request.contextPath}/public/imgs/sp/${p.proID}/main_thumbs.jpg" alt="${p.proName}" title="${p.proName}" class="card-img-top">
                    <div class="card-body">
                      <h4 class="card-title">${p.proName}</h4>
                      <h5 class="card-title text-danger">
                        <fmt:formatNumber value="${p.price}" type="number"/>
                      </h5>
                      <p class="card-text">${p.tinyDes}</p>
                    </div>
                    <div class="card-footer text-muted">
                      <a class="btn btn-sm btn-outline-primary" href="${pageContext.request.contextPath}/Product/Detail?id=${p.proID}" role="button">
                        <i class="fa fa-eye" aria-hidden="true"></i>
                        Details
                      </a>
                      <a class="btn btn-sm btn-outline-success" href="#" role="button">
                        <i class="fa fa-cart-plus" aria-hidden="true"></i>
                        Add to cart
                      </a>
                    </div>
                  </div>
                </div>
              </c:forEach>
            </div>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </jsp:body>
</t:main>
