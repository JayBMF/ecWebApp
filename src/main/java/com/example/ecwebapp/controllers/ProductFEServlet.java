package com.example.ecwebapp.controllers;

import com.example.ecwebapp.beans.Category;
import com.example.ecwebapp.beans.Product;
import com.example.ecwebapp.models.CategoryModel;
import com.example.ecwebapp.models.ProductModel;
import com.example.ecwebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductFEServlet", value = "/Product/*")
public class ProductFEServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path= request.getPathInfo();
        switch (path){
            case "/ByCat":
                int catId= Integer.parseInt(request.getParameter("id"));
                List<Product> list = ProductModel.findByCatId(catId);
                request.setAttribute("products", list);
                ServletUtils.forward("/Views/vwProduct/ByCat.jsp", request, response);
                break;
            case "/Detail":
                ServletUtils.forward("/Views/vwCategory/Detail.jsp", request, response);
                break;

            default:
                ServletUtils.forward("/Views/404.jsp", request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
