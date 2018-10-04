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
import mapper.PersonMapper;

@Path("person")
public class PersonREST {

    PersonMapper m = new PersonMapper(Persistence.createEntityManagerFactory("pu"));
    Gson gson = new Gson();
    
    @Context
    private UriInfo context;
    

    /**
     * Creates a new instance of GenericResource
     */
    public PersonREST() {
    }
    
    @Path("{id}")
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
    
    @Path("allzip")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllZipCodes(){
        List<CityInfoDTO> ziplist = m.getAllZipCodes();
        
        return Response.ok(gson.toJson(ziplist)).build();
    }
    
    @Path("hobby/{hobby}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonAndCountWithGivenHobby(@PathParam("hobby") String hobby){
        List<PersonDTO> person = m.findPersonsWithGivenHobby(hobby);
        
        return Response.ok(gson.toJson(person)).build();
    }
    
    @Path("{firstname}/{lastname}/{email}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(@PathParam("firstname") String firstname, @PathParam("lastname") String lastname, @PathParam("email") String email){
        Person p = new Person(email, firstname, lastname);
        p = m.createPerson(p);
        return Response.ok(gson.toJson(p)).build();
    }

    
    @Path("delete/{number}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePerson(@PathParam("number") int id){

        Person p = m.findPersonById(id);
        
        Person p1 = m.deletePerson(p);
        
        return Response.ok(gson.toJson(p1)).build();
    }
}
