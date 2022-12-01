package com.example.ecwebapp.controllers;

import com.example.ecwebapp.beans.Product;
import com.example.ecwebapp.models.ProductModel;
import com.example.ecwebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductUserServlet", value = "/Product/*")
public class ProductUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path= request.getPathInfo();
        switch (path){
            case "ByCat":
                int catId= Integer.parseInt(request.getParameter("id"));
                List<Product> list= ProductModel.findByCatId(catId);
                break;
            default:
                ServletUtils.forward("/views/404.jsp", request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
