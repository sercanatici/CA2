/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author sidad
 */
public class PersonDTO {
    public int id;
    public String email;
    public String firstName;
    public String lastName;
    
    public String hobbyName;
    public String hobbyDescription;
    
    public int phoneNumber;
    public String phoneDescription;
    
    public String street;
    public String additionalInfo;
    
    public int zipCode;
    public String city;

    public PersonDTO(){
        
    }
    
    public PersonDTO(int id, String email, String firstName, String lastName, String hobbyName, String hobbyDescription, int phoneNumber, String phoneDescription, String street, String additionalInfo, int zipCode, String city) {
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

    public PersonDTO(int id, String email, String firstName, String lastName, int phoneNumber) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    
    
    
}
