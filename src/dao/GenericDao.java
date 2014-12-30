package com.mss.store.videogame.dao;

import java.util.List;

public interface GenericDao<E> {

    void save(E entity);
    
    void update(E entity);
     
    void remove(E entity);
     
    E lookupById(int key);
     
    List<E> list();


    
}
