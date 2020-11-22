/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.core;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pranish
 */
public class JdbcTemplate<T> {
    private Connection getConnection()throws Exception{
        String url = "jdbc:mysql://localhost/dproject?serverTimezone=UTC";
        String user = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.
                getConnection(url, user, password);
    }
    
    public List<T> query(String sql,RowMapper<T> mapper)throws Exception{
         List<T> rows = new ArrayList<>();
         Connection conn=getConnection();
         PreparedStatement stmt=conn.prepareStatement(sql);
          ResultSet rs = stmt.executeQuery();
        while (rs.next()){
            rows.add(mapper.maprow(rs));
        }
        conn.close();
        return rows;
    }
    private void setParameters(PreparedStatement stmt,Object[] params)throws Exception{
         int counter=1;
        for (Object param:params){
            stmt.setObject(counter, param);
            counter++;
        }
    }
     public T queryForObject(String sql,Object[]params,RowMapper<T> mapper)throws Exception{
         T row=null;
         Connection conn=getConnection();
         PreparedStatement stmt=conn.prepareStatement(sql);
         setParameters(stmt, params);
         ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            row=mapper.maprow(rs);
        }
        conn.close();
        return row;
    }
    
    public int update(String sql,Object[] params)throws Exception{
        Connection conn=getConnection();
        PreparedStatement stmt=conn.prepareStatement(sql);
        setParameters(stmt, params);
        int result=stmt.executeUpdate();
        conn.close();
        return result;
    }
}
