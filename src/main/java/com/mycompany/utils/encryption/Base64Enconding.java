/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils.encryption;



import java.util.Base64;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author jean
 */
public class Base64Enconding {
    
    public static String encode(String value){       
        return Base64.getEncoder().encodeToString(value.getBytes());
    }
    
    public static String decode(String value) throws UnsupportedEncodingException{
        byte[] bytes = Base64.getDecoder().decode(value);
        return new String(bytes, "utf-8");
    }
    
    
}
