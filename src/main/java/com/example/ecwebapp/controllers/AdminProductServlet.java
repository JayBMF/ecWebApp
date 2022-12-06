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

@WebServlet(name = "AdminProductServlet", value = "/Admin/Product/*")
public class AdminProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path= request.getPathInfo();
        if (path==null || path.equals("/")){
            path= "/Index";
        }
        switch (path){
            case "/Index":
                List<Product> list = ProductModel.findAll();
                request.setAttribute("products", list);
                ServletUtils.forward("/Views/vwProduct/Index.jsp", request, response);
                break;
            case "/Add":
                ServletUtils.forward("/Views/vwProduct/Add.jsp", request, response);
                break;
            case "/Edit":
                int id=0;
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                }catch (NumberFormatException e){

                }
                Product p= ProductModel.findById(id);
                if (p != null){
                    request.setAttribute("product", p);
                    ServletUtils.forward("/Views/vwProduct/Edit.jsp", request,response);
                }else {
                    ServletUtils.redirect("/Admin/Product", request, response);
//                    ServletUtils.redirect("/Views/204.jsp", request, response);
                }

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
