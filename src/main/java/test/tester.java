/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
import mapper.PersonMapper;

/**
 *
 * @author sidad
 */
public class tester {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        
        PersonMapper pm = new PersonMapper(emf);
        
        Person p = new Person("email", "Tobias", "Jensen");
        CityInfo cf = pm.getCityInfoByZip(2800);
        Address a = new Address("LyngbyGade", "Info om lyngby", cf);
        ArrayList<Phone> plist = new ArrayList();
        plist.add(new Phone(123, "Home", p));
        plist.add(new Phone(456, "Work", p));
        plist.add(new Phone(789, "Private", p));
        ArrayList<Hobby> hlist = new ArrayList();
        hlist.add(new Hobby("Sailing", "Sailing"));
        hlist.add(new Hobby("Fishing", "Fishing"));
        pm.createFullPerson(p, a, plist, hlist);
        
    
        
        Long count = pm.getCountOfPeopleWithGivenHobby("Fishing");
        System.out.println(count);
        List<PersonDTO> person = pm.findPersonsWithGivenCity("Kongens Lyngby");
        System.out.println(person.get(0).toString());
       
    }
    
}
