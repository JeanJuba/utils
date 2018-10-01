/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jean
 * @param <T>
 */
public interface Dao<T> {
    
    public T find(Serializable id);
    
    public void insert(T entity);
    
    public void remove(T entity);
    
    public void update(T entity);
    
    public List<T> listAll();
    
}
