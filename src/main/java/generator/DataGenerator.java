/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generator;

import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tobbe
 */
public class DataGenerator {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    PersonFacade pf = new PersonFacade(emf);
    Random rand = new Random();
    
    List<String> firstnames = new ArrayList();
    List<String> lastnames = new ArrayList();
    List<String> street = new ArrayList();
    List<String> info = new ArrayList();
    List<String> hobby = new ArrayList();
    
    
    public Person personMaker(){
        int firstRand = rand.nextInt(5)+0;
        int lastRand = rand.nextInt(5)+0;
        firstnames.add("Frederik");firstnames.add("Martin");firstnames.add("Kasper");firstnames.add("Emil");firstnames.add("Nikolaj");
        lastnames.add("Frederiksen");lastnames.add("Martinsen");lastnames.add("Kaspersen");lastnames.add("Emilsen");lastnames.add("Nikolajsen");
        String email = "Email@hotmail.com";
        return new Person(email, firstnames.get(firstRand), lastnames.get(lastRand));
    }
    
    public Address addressMaker(){
        int firstRand = rand.nextInt(3)+0;
        int lastRand = rand.nextInt(3)+0;
        street.add("LyngbyGade");street.add("BreddeGade");street.add("NyGade");
        info.add("info om Lyngbygade");info.add("info om Breddegade");info.add("info om Nygade");
        CityInfo cf = pf.getCityInfoByZip(3000);
        return new Address(street.get(firstRand), street.get(lastRand), cf);
    }
    
    public ArrayList<Hobby> hobbyMaker(){
        ArrayList<Hobby> hlist = new ArrayList();
        int index = rand.nextInt(3)+0;
        hobby.add("Fishing");hobby.add("Coding");hobby.add("Sailing");
        hlist.add(new Hobby(hobby.get(index), hobby.get(index)));
        return hlist;
    }
    
    public ArrayList<Phone> phoneMaker(){
        List<Phone> phonelist = new ArrayList();
        Person p = personMaker();
        phonelist.add(new Phone(123, "Work", p));phonelist.add(new Phone(456, "Private", p));phonelist.add(new Phone(789, "Home", p));
        int index = rand.nextInt(3)+0;
        ArrayList<Phone> returnList = new ArrayList();
        returnList.add(phonelist.get(index));
        return returnList;
    }
    
    
    public List<PersonDTO> Generator(int amount){
        List<PersonDTO> list = new ArrayList();
        for(int i = 0; i < amount; i++){
            ArrayList<Phone> plist = phoneMaker();
            Person p = plist.get(0).getPerson();
            Address a = addressMaker();
            ArrayList<Hobby> hlist = hobbyMaker();
            
            pf.createFullPerson(p, a, plist, hlist);
            PersonDTO pdto = pf.findFullPersonDTOById(i+1);
            list.add(pdto);
        }
        return list;
    }
}
