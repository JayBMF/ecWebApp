package com.example.ecwebapp.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.ecwebapp.beans.User;
import com.example.ecwebapp.models.UserModel;
import com.example.ecwebapp.utils.ServletUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "AccountServlet", value = "/Account/*")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path= request.getPathInfo();
        switch (path){
            case "/Register":
                ServletUtils.forward("/Views/vwAccount/Register.jsp", request, response);
                break;

            case "/Login":
                ServletUtils.forward("/Views/vwAccount/Login.jsp", request, response);
                break;

            case "/Profile":
                ServletUtils.forward("/Views/vwAccount/Profile.jsp", request, response);
                break;

            case "/IsAvailable":
                String username= request.getParameter("user");
                User user = UserModel.findByUsername(username);
                boolean isAvailable= (user==null);


                PrintWriter out= response.getWriter();
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");

                out.print(false);
                out.flush();
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
            case "/Register":
                registerUser(request, response);
                break;
            case "/Login":
                login(request,response);
                break;

            default:
                ServletUtils.forward("/Views/404.jsp", request,response);
                break;
        }
    }

    private static void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rawpwd= request.getParameter("rawpwd");
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, rawpwd.toCharArray());

        String username= request.getParameter("username");
        String name= request.getParameter("name");
        String email= request.getParameter("email");

        String strDob= request.getParameter("dob");
        DateTimeFormatter df= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob= LocalDate.parse(strDob, df);

        int permission=0;
        User u= new User(0, username,bcryptHashString,name,email, dob, permission);
        UserModel.add(u);
        ServletUtils.forward("/Views/vwAccount/Register.jsp", request, response);
    }


    private static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int id= Integer.parseInt(request.getParameter("CatID"));
//        CategoryModel.delete(id);
//        ServletUtils.redirect("/Admin/Category", request, response);
    }
}
