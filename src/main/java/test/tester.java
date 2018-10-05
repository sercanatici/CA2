/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dto.CityInfoDTO;
import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import facade.PersonFacade;
import generator.DataGenerator;

/**
 *
 * @author sidad
 */
public class tester {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        PersonFacade pm = new PersonFacade(emf);
        DataGenerator dg = new DataGenerator();
        dg.Generator(10);
        
    }
    
}
