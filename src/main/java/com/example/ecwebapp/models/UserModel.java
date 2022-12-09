package com.example.ecwebapp.models;


import com.example.ecwebapp.beans.User;
import com.example.ecwebapp.utils.DbUtils;
import org.sql2o.Connection;

import java.util.List;


public class UserModel {

    public static void add(User u){

        String insertSql = "INSERT INTO users ( username, password, name, email, dob, permission) VALUES (:username,:password,:name,:email,:dob,:permission)\n";

        try (Connection con = DbUtils.getConnection()) {
            con.createQuery(insertSql)
                    .addParameter("username", u.getUsername())
                    .addParameter("password", u.getPassword())
                    .addParameter("name", u.getName())
                    .addParameter("email", u.getEmail())
                    .addParameter("dob", u.getDob())
                    .addParameter("permission", u.getPermission())
                    .executeUpdate();
        }
    }


    public static User findByUsername(String username){

        final String sql= "select * from users where username = :username";
        try (Connection con= DbUtils.getConnection()) {
            List<User> list= con.createQuery(sql)
                    .addParameter("username", username)
                    .executeAndFetch(User.class);

            if (list.size()==0){
                return null;
            }
            return list.get(0);
        }
    }
}
