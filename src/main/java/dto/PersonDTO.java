/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entity.Hobby;
import entity.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sidad
 */
public class PersonDTO {
    public Long id;
    public String email;
    public String firstName;
    public String lastName;
    
    public String hobbyName;
    public String hobbyDescription;
    public List<HobbyDTO> harray = new ArrayList();
    
    public int phoneNumber;
    public String phoneDescription;
    
    public String street;
    public String additionalInfo;
    
    public int zipCode;
    public String city;

    public PersonDTO(){
        
    }

    public PersonDTO(Long id, String email, String firstName, String lastName, String hobbyName, String hobbyDescription, int phoneNumber, String phoneDescription, String street, String additionalInfo, int zipCode, String city) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hobbyName = hobbyName;
        this.hobbyDescription = hobbyDescription;
        this.phoneNumber = phoneNumber;
        this.phoneDescription = phoneDescription;
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.zipCode = zipCode;
        this.city = city;
    }
    
    public PersonDTO(Person p, int phoneNumber, String phoneDescription, String street, String additionalInfo, int zipCode, String city){
        this.id = p.getId();
        this.email = p.getEmail();
        this.firstName = p.getFirstName();
        this.lastName = p.getLastName();
        for(int i = 0; i < p.getHobbys().size(); i++){
            harray.add(new HobbyDTO(p.getHobbys().get(i).getName(), p.getHobbys().get(i).getDescription()));
        }
        this.phoneNumber = phoneNumber;
        this.phoneDescription = phoneDescription;
        this.street = street;
        this.additionalInfo = additionalInfo;
        this.zipCode = zipCode;
        this.city = city;
        
    }
    
    public PersonDTO(Long id, String email, String firstName, String lastName, int phoneNumber) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    
    public PersonDTO(long id, String email, String firstName, String lastName){
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", hobbyName=" + hobbyName + ", hobbyDescription=" + hobbyDescription + ", harray=" + harray + ", phoneNumber=" + phoneNumber + ", phoneDescription=" + phoneDescription + ", street=" + street + ", additionalInfo=" + additionalInfo + ", zipCode=" + zipCode + ", city=" + city + '}';
    }
    
    
    
}
