package com.example.ecwebapp.filters;

import com.example.ecwebapp.beans.Category;
import com.example.ecwebapp.models.CategoryModel;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "LayoutFilter")
public class LayoutFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        List<Category> list= CategoryModel.findAll();
        request.setAttribute("categoriesWithDetails", list);

        chain.doFilter(request, response);
    }
}
