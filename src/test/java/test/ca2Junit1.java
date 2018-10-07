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
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import facade.PersonFacade;
import generator.DataGenerator;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tobbe
 */
public class ca2Junit1 {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    PersonFacade pm = new PersonFacade(emf);
    DataGenerator dg = new DataGenerator();

    public ca2Junit1() {
    }


    @Test
    public void testCreateAndFindPerson(){
        Person p = dg.personMaker();
        p = pm.createPerson(p);
        long id = p.getId();
        PersonDTO p2 = pm.findPersonDTOById((int) id);
        assertEquals(p.getId(), p2.getId());
        assertEquals(p.getEmail(), p2.getEmail());
        assertEquals(p.getFirstName(), p2.getFirstName());
        assertEquals(p.getLastName(), p.getLastName());
    }
    
    @Test
    public void testCreateAndFindFullPerson(){
        Address a = dg.addressMaker();
        ArrayList<Phone> plist = dg.phoneMaker();
        Person p = plist.get(0).getPerson();
        ArrayList<Hobby> hlist = dg.hobbyMaker();
        
        Person p1 = pm.createFullPerson(p, a, plist, hlist);
        long id = p1.getId();
        PersonDTO p2 = pm.findFullPersonDTOById((int) id);
        
        assertEquals(p1.getId(), p2.getId());
        assertEquals(p1.getLastName(), p2.getLastName());
        assertEquals(p1.getPhones().get(0).getNumber(), p2.getPhoneNumber());
        
    }
    
    @Test
    public void testDeletePerson(){
        List<PersonDTO> list1 = pm.findAllPeople();
        PersonDTO p = pm.findFullPersonDTOById(1);
        pm.deletePersonById(p.getId());
        List<PersonDTO> list2 = pm.findAllPeople();
        assertEquals(list1.size() -1, list2.size());
        
    }

    @Test
    public void testGetALlZipCodes(){
        List<CityInfoDTO> zip = pm.getAllZipCodes();
        int actual = zip.size();
        int expected = 1352;
        assertEquals(actual, expected);
    }
    
    @Test
    public void testUpdatePerson(){
        Person oldPerson = pm.findPersonById(1);
        Person newPerson = new Person("Email","Ny", "Person");
        
        pm.updatePerson(oldPerson, newPerson);
        
        oldPerson = pm.findPersonById(1);
        
        assertEquals(oldPerson.getEmail(), newPerson.getEmail());
        assertEquals(oldPerson.getFirstName(), newPerson.getFirstName());
        assertEquals(oldPerson.getLastName(), newPerson.getLastName());
    }
}
