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
public class HobbyDTO {
    public String hobbyName;
    public String hobbyDescription;
    
    public HobbyDTO(){
        
    }

    public HobbyDTO(String hobbyName, String hobbyDescription) {
        this.hobbyName = hobbyName;
        this.hobbyDescription = hobbyDescription;
    }
    
}
