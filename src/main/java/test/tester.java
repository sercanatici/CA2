/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mapper.PersonMapper;

/**
 *
 * @author sidad
 */
public class tester {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        
        PersonMapper pm = new PersonMapper(emf);
        
        System.out.println(pm.getAllZipCodes());
        System.out.println("hello"); 
        
    
    }
    
}
