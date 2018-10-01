/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jean
 * @param <T>
 */
public class GenericDao<T> implements Dao<T> {

   private final EntityManager em;
   private final Class<T> clazz;
    
   public GenericDao(Class clazz){
       em = EMFactory.getEntityManager();
       this.clazz = clazz;
       
   }
   
    @Override
    public T find(Serializable id) {
        return em.find(clazz, id);
    }

    @Override
    public void insert(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    @Override
    public void remove(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    @Override
    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    @Override
    public List<T> listAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cquery = cb.createQuery(clazz);
        Root<T> root = cquery.from(clazz);
        cquery.orderBy(cb.asc(root));
        
        return em.createQuery(cquery).getResultList();
    }
    
}
