/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.client.repository;

import java.util.List;

/**
 *
 * @author Pranish
 */
public interface CRUDRepository<T> {
    List<T> findAll() throws Exception;
    int insert(T model)throws Exception;
    int update(T model)throws Exception;
    int delete(int id)throws Exception;
    T findById(int id)throws Exception;
    
}
