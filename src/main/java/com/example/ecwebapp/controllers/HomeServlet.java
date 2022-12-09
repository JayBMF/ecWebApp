package com.example.ecwebapp.controllers;


import com.example.ecwebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/Home/*")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String path= request.getPathInfo();
    if (path==null || path.equals("/")){
        path= "/Index";
    }
    switch (path){
        case "/Index":
            ServletUtils.forward("/Views/vwHome/Index.jsp", request, response);
            break;
        case "/About":
            ServletUtils.forward("/Views/vwHome/About.jsp", request, response);
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
