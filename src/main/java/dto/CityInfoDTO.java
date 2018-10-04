/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author tobbe
 */
public class CityInfoDTO {
    public String city;
    public int zip;
    
    public CityInfoDTO(){
        
    }
    
    public CityInfoDTO(String city, int zip){
        this.city = city;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "CityInfoDTO{" + "city=" + city + ", zip=" + zip + '}';
    }
    
    
}
