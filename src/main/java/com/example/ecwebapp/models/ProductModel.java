package com.example.ecwebapp.models;


import com.example.ecwebapp.beans.Category;
import com.example.ecwebapp.beans.Product;
import com.example.ecwebapp.utils.DbUtils;
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
        final String sql= "select * from products where CatID= :CatID";
        try (Connection con= DbUtils.getConnection()) {
            return con.createQuery(sql)
                    .addParameter("CatID", catId)
                    .executeAndFetch(Product.class);
        }
    }


    public static Product findById(int id){
        final String sql= "select * from products where ProID= :ProID";
        try (Connection con= DbUtils.getConnection()) {
            List<Product> list= con.createQuery(sql)
                    .addParameter("ProID", id)
                    .executeAndFetch(Product.class);

            if (list.size()==0){
                return null;
            }
            return list.get(0);
        }
    }
}
