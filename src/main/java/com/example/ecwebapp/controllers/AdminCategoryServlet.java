package com.example.ecwebapp.controllers;

import com.example.ecwebapp.beans.Category;
import com.example.ecwebapp.models.CategoryModel;
import com.example.ecwebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCategoryServlet", value = "/Admin/Category/*")
public class AdminCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path= request.getPathInfo();
        if (path==null || path.equals("/")){
            path= "/Index";
        }
        switch (path){
            case "/Index":
//                Category c = new Category(1,"Sách");
//                request.setAttribute("category", c);

                List<Category> list = CategoryModel.findAll();
                request.setAttribute("categories", list);
                ServletUtils.forward("/Views/vwCategory/Index.jsp", request, response);
                break;
            case "/Add":
                ServletUtils.forward("/Views/vwCategory/Add.jsp", request, response);
                break;
            default:
                ServletUtils.forward("/Views/404.jsp", request,response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path= request.getPathInfo();
        switch (path){
            case "/Add":
                String name= request.getParameter("CatName");
                Category c= new Category(name);
                CategoryModel.add(c);
                ServletUtils.forward("/Views/vwCategory/Add.jsp", request, response);
                break;
            default:
                ServletUtils.forward("/Views/404.jsp", request,response);
                break;
        }
    }
}
