/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author jean
 */
public class Sha256Hashing {

    public static byte[] hashValue(String value) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("sha-256");

        return md.digest(value.getBytes());
    }

}
