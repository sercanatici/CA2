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
    public Long DTOid;
    public String DTOemail;
    public String DTOfirstName;
    public String DTOlastName;
    
    public String DTOhobbyName;
    public String DTOhobbyDescription;
    public List<HobbyDTO> DTOharray = new ArrayList();
    
    public int DTOphoneNumber;
    public String DTOphoneDescription;
    
    public String DTOstreet;
    public String DTOadditionalInfo;
    
    public int DTOzipCode;
    public String DTOcity;

    public PersonDTO(){
        
    }

    public PersonDTO(Long id, String email, String firstName, String lastName, String hobbyName, String hobbyDescription, int phoneNumber, String phoneDescription, String street, String additionalInfo, int zipCode, String city) {
        this.DTOid = id;
        this.DTOemail = email;
        this.DTOfirstName = firstName;
        this.DTOlastName = lastName;
        this.DTOhobbyName = hobbyName;
        this.DTOhobbyDescription = hobbyDescription;
        this.DTOphoneNumber = phoneNumber;
        this.DTOphoneDescription = phoneDescription;
        this.DTOstreet = street;
        this.DTOadditionalInfo = additionalInfo;
        this.DTOzipCode = zipCode;
        this.DTOcity = city;
    }
    
    public PersonDTO(Person p, int phoneNumber, String phoneDescription, String street, String additionalInfo, int zipCode, String city){
        this.DTOid = p.getId();
        this.DTOemail = p.getEmail();
        this.DTOfirstName = p.getFirstName();
        this.DTOlastName = p.getLastName();
        for(int i = 0; i < p.getHobbys().size(); i++){
            DTOharray.add(new HobbyDTO(p.getHobbys().get(i).getName(), p.getHobbys().get(i).getDescription()));
        }
        this.DTOphoneNumber = phoneNumber;
        this.DTOphoneDescription = phoneDescription;
        this.DTOstreet = street;
        this.DTOadditionalInfo = additionalInfo;
        this.DTOzipCode = zipCode;
        this.DTOcity = city;
        
    }
    
    public PersonDTO(Long id, String email, String firstName, String lastName, int phoneNumber) {
        this.DTOid = id;
        this.DTOemail = email;
        this.DTOfirstName = firstName;
        this.DTOlastName = lastName;
        this.DTOphoneNumber = phoneNumber;
    }
    
    public PersonDTO(Long id, String firstName, String lastName, String email){
        this.DTOid = id;
        this.DTOemail = email;
        this.DTOfirstName = firstName;
        this.DTOlastName = lastName;
    }

    
    
    
    
}
