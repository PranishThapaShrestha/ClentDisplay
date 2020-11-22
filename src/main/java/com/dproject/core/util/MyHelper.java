/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dproject.core.util;

/**
 *
 * @author Pranish
 */
public class MyHelper {
    public static boolean isNumeric(String data){
        try{
            int result=Integer.parseInt(data);
            return true;
        }catch(NumberFormatException ne){
            return false;
        }
    }
}
