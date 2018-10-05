/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import dto.CityInfoDTO;
import dto.PersonDTO;
import entity.CityInfo;
import entity.Person;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import facade.PersonFacade;

@Path("options")
public class PersonREST {

    PersonFacade m = new PersonFacade(Persistence.createEntityManagerFactory("pu"));
    Gson gson = new Gson();
    
    @Context
    private UriInfo context;
    

    /**
     * Creates a new instance of GenericResource
     */
    public PersonREST() {
    }
    
    @Path("person/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPeople(){
        List<PersonDTO> p = m.findAllPeople();
        
        return Response.ok(gson.toJson(p)).build();
    }
    
    
    
    @Path("person/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") int id){
        List<PersonDTO> p = m.findPersonDTOById(id);
        
        return Response.ok(gson.toJson(p)).build();
    }
    
    @Path("phone/{number}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonFromPhoneNumber(@PathParam("number") int number) {
        
        List<PersonDTO> person = m.findPersonFromPhoneNumber(number);
        
        return Response.ok(gson.toJson(person)).build();
    }
    
    @Path("zip/allzip")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllZipCodes(){
        List<CityInfoDTO> ziplist = m.getAllZipCodes();
        
        return Response.ok(gson.toJson(ziplist)).build();
    }
    
    @Path("person/hobby/{hobby}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonAndCountWithGivenHobby(@PathParam("hobby") String hobby){
        List<PersonDTO> person = m.findPersonsWithGivenHobby(hobby);
        
        return Response.ok(gson.toJson(person)).build();
    }
    
    @Path("person/{email}/{firstname}/{lastname}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(@PathParam("email") String email, @PathParam("firstname") String firstname, @PathParam("lastname") String lastname){
        Person p = new Person(email, firstname, lastname);
        p = m.createPerson(p);
        return Response.ok(gson.toJson(p)).build();
    }
    
    @Path("person/update/{id}/{firstname}/{lastname}/{email}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("id") int id, @PathParam("firstname") String firstname, @PathParam("lastname") String lastname, @PathParam("email") String email){
        Person oldPerson = m.findPersonById(id);
        Person newPerson = new Person(firstname, lastname, email);
        
        m.updatePerson(oldPerson, newPerson);
        
        return Response.ok(gson.toJson(newPerson)).build();
    }
    
    @Path("person/delete/{number}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("number") Long id){

        Person p = m.deletePersonById(id);
        
        return Response.ok().build();
    }
}
