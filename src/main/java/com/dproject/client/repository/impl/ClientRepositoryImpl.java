/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.client.repository.impl;

import com.dproject.client.entity.Client;
import com.dproject.client.repository.ClientRepository;
import com.dproject.core.JdbcTemplate;
import com.dproject.core.RowMapper;
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
public class ClientRepositoryImpl implements ClientRepository {

    JdbcTemplate<Client> template = new JdbcTemplate<>();

    @Override
    public List<Client> findAll() throws Exception {
        String sql = "Select * from user_tbl";
        return template.query(sql, new ClientRowMapper());
    }

    @Override
    public Client findById(int id) throws Exception {
        String sql = "Select * from user_tbl where id=?";
        return template.queryForObject(sql, new Object[]{id},
                new ClientRowMapper());
    }
    
    @Override
    public int insert(Client client) throws Exception {

        String sql = "insert into user_tbl(username,email,address)values(?,?,?)";
        return template.update(sql, new Object[]{
            client.getName(), client.getEmail(), client.getAddress()
        });
    }

    

    @Override
    public int update(Client client) throws Exception {
          String sql = "update user_tbl set name=?,email=?,address=? where id=?";
        return template.update(sql, new Object[]{
            client.getName(), client.getEmail(), client.getAddress(),client.getId()
        });
    }

   

    @Override
    public int delete(int id) throws Exception {
        String sql="delete from user_clients where id=?";
        return template.update(sql, new Object[]{id});
    }

    private class ClientRowMapper implements RowMapper<Client> {

        @Override
        public Client maprow(ResultSet rs) throws Exception {
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("username"));
            client.setEmail(rs.getString("email"));
            client.setAddress(rs.getString("address"));
            client.setStatus(rs.getBoolean("status"));
            return client;
        }

    }

}
