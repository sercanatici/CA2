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

/**
 *
 * @author sidad
 */
public class tester {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        
        PersonFacade pm = new PersonFacade(emf);
        
        Person p = new Person("Tobbejj@hotmail.com", "Tobias", "Jensen");
        CityInfo cf = pm.getCityInfoByZip(3650);
        Address a = new Address("Jattevej", "Info om Jattevej", cf);
        ArrayList<Phone> plist = new ArrayList();
        plist.add(new Phone(123456, "Home", p));
        plist.add(new Phone(756371, "Work", p));
        plist.add(new Phone(947718, "Private", p));
        ArrayList<Hobby> hlist = new ArrayList();
        hlist.add(new Hobby("Sailing", "Sailing"));
        hlist.add(new Hobby("Fishing", "Fishing"));
        pm.createFullPerson(p, a, plist, hlist);
        
        Person p1 = new Person("Sercan@hotmail.com", "Sercan", "Atici");
        CityInfo cf1 = pm.getCityInfoByZip(2800);
        Address a1 = new Address("LyngbyGade", "Info om lyngby", cf1);
        ArrayList<Phone> plist1 = new ArrayList();
        plist1.add(new Phone(123, "Home", p1));
        plist1.add(new Phone(456, "Work", p1));
        plist1.add(new Phone(789, "Private", p1));
        ArrayList<Hobby> hlist1 = new ArrayList();
        hlist1.add(new Hobby("Sailing", "Sailing"));
        hlist1.add(new Hobby("Coding", "Coding"));
        pm.createFullPerson(p1, a1, plist1, hlist1);

    }
    
}
