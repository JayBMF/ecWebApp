package com.example.ecwebapp.models;

import com.example.ecwebapp.beans.Category;
import com.example.ecwebapp.utils.DbUtils;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CategoryModel {

    public static List<Category> findAll(){

        final String sql= "select * from categories";
        try (Connection con= DbUtils.getConnection()) {
            return con.createQuery(sql).executeAndFetch(Category.class);
        }
    }

    public static void add(Category c){

        String insertSql = "INSERT INTO categories (CatName) VALUES (:catname)";

        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("catname", c.getCatName())
                    .executeUpdate();
        }
    }

    public static Category findById(int id){

        final String sql= "select * from categories where CatID= (:CatID)";
        try (Connection con= DbUtils.getConnection()) {
            List<Category> list= con.createQuery(sql)
                    .addParameter("CatID", id)
                    .executeAndFetch(Category.class);

            if (list.size()==0){
                return null;
            }
            return list.get(0);
        }
    }
}
