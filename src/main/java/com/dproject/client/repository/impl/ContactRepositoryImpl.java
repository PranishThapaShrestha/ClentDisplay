/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.client.repository.impl;

import com.dproject.client.entity.Contact;
import com.dproject.client.repository.ContactRepository;
import com.dproject.core.JdbcTemplate;
import com.dproject.core.RowMapper;

import java.sql.ResultSet;

import java.util.List;

/**
 *
 * @author Pranish
 */
public class ContactRepositoryImpl implements ContactRepository {

    private JdbcTemplate<Contact> template = new JdbcTemplate<>();

    @Override
    public List<Contact> findAll() throws Exception {

        String sql = "Select * from user_contacts";
        return template.query(sql, new ContactRowMapper());
    }

    @Override
    public Contact findById(int id) throws Exception {
        String sql = "select * from user_contacts where id=?";
        return template.queryForObject(sql,
                new Object[]{id}, new ContactRowMapper());
    }

    @Override
    public int insert(Contact contact) throws Exception {

        String sql = "insert into user_contacts(name,email)values(?,?)";
        return template.update(sql, new Object[]{
            contact.getName(), contact.getEmail()
        });

    }

    @Override
    public int update(Contact contact) throws Exception {
        String sql = "update user_contacts set name=?,email=? where id=?";
        return template.update(sql, new Object[]{
            contact.getName(), contact.getEmail(), contact.getId()
        });
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from user_contacts where id=?";
        return template.update(sql, new Object[]{id});
    }

    private class ContactRowMapper implements RowMapper<Contact> {

        @Override
        public Contact maprow(ResultSet rs) throws Exception {
            Contact contact = new Contact();
            contact.setId(rs.getInt("id"));
            contact.setName(rs.getString("name"));
            contact.setEmail(rs.getString("email"));
            contact.setCreated(rs.getDate("created_Date"));
            contact.setStatus(rs.getBoolean("status"));
            return contact;
        }

    }

}
