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
    
    public PersonDTO(Long id, String firstName, String lastName, String email){
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public String getHobbyDescription() {
        return hobbyDescription;
    }

    public void setHobbyDescription(String hobbyDescription) {
        this.hobbyDescription = hobbyDescription;
    }

    public List<HobbyDTO> getHarray() {
        return harray;
    }

    public void setHarray(List<HobbyDTO> harray) {
        this.harray = harray;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneDescription() {
        return phoneDescription;
    }

    public void setPhoneDescription(String phoneDescription) {
        this.phoneDescription = phoneDescription;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    
    
    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", hobbyName=" + hobbyName + ", hobbyDescription=" + hobbyDescription + ", phoneNumber=" + phoneNumber + ", phoneDescription=" + phoneDescription + ", street=" + street + ", additionalInfo=" + additionalInfo + ", zipCode=" + zipCode + ", city=" + city + '}';
    }

    
    
    
    
}
