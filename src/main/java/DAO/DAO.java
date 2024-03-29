/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;

/**
 *
 * @author kwist
 */
public interface DAO<T> {
    List<T> readAll();
    
    T readOne(String... ids);
    
    List<T> readSome(String... ids);
    
    int create(T t);
    
    int update(T t);
    
    int delete(T t);
    
    List<T> readAllIds(String... ids);
    
    int lastCode();
}
