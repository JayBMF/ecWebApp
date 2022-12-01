package com.example.ecwebapp.models;


import com.example.ecwebapp.beans.Product;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class ProductModel {
    public static List<Product> findAll(){
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/ecdbj", "root", "");
        String sql= "select * from products";
        try (Connection con= sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Product.class);
        }
    }

    public static List<Product> findByCatId(int catId){
        Sql2o sql2o = new Sql2o("jdbc:mysql://localhost:3306/ecdbj", "root", "");
        String sql= "select * from products order by catId";
        try (Connection con= sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Product.class);
        }
    }
}
