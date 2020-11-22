/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.core;

import java.sql.ResultSet;

/**
 *
 * @author Pranish
 */
public interface RowMapper<T> {
    T maprow(ResultSet rs)throws Exception;
    
}
