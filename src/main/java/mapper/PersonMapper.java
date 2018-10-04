package mapper;

import dto.CityInfoDTO;
import dto.PersonDTO;
import entity.Address;
import entity.CityInfo;
import entity.Hobby;
import entity.Person;
import entity.Phone;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PersonMapper {

    EntityManagerFactory emf;

    public PersonMapper(EntityManagerFactory emf) {
        this.emf = emf;
    }

    EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Person createPerson(Person p){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return p;
    }
    
    public Person createPersonWithAddress(Person p, Address a){
        EntityManager em = getEntityManager();
        try{
            a.setCityinfo(a.getCityinfo());
            p.setAddress(a);
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return p;
    }
    
    public Person createFullPerson(Person p, Address a, ArrayList<Phone> plist, ArrayList<Hobby> hlist){
        EntityManager em = getEntityManager();
        try{
            a.setCityinfo(a.getCityinfo());
            p.setAddress(a);
            p.setHobbys(hlist);
            p.setPhones(plist);
            
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }finally{
            em.close();
        }
        return p;
    }
    
    public Person findPersonById(int id){
        EntityManager em = getEntityManager();
        try{
            Query query = em.createQuery("Select c from Person c where c.id = :id");
            query.setParameter("id", id);
            Person p = (Person) query.getSingleResult();
            return p;
        }finally{
            em.close();
        }
    }
    
    public Person deletePersonById(Person p){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.remove(em.contains(p) ? p : em.merge(p));
            em.getTransaction().commit();
            return p;
      
        }finally{
            em.close();
        }
    }
    
    public Person updatePerson(Person personOriginal, Person personNew){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            personOriginal.setEmail(personNew.getEmail());
            personOriginal.setFirstName(personNew.getFirstName());
            personOriginal.setLastName(personNew.getLastName());
            em.merge(personOriginal);
            em.getTransaction().commit();
            return personNew;
        }finally{
            em.close();
        }
    }
            
    
    public CityInfo getCityInfoByZip(int zip){
        EntityManager em = getEntityManager();
        try{
            Query query = em.createQuery("Select c from CityInfo c where c.zip = :zip ");
            query.setParameter("zip", zip);
            CityInfo cf = (CityInfo) query.getSingleResult();
            return cf;
        }finally{
            em.close();
        }
    }
          
    public List<PersonDTO> findPersonFromPhoneNumber(int number) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<PersonDTO> query = em.createQuery("select new dto.PersonDTO(c1, c2.number, c2.description, c3.street, c3.additionalInfo, c4.zip, c4.city) "
                    + "from Person c1 inner join c1.phones as c2 "
                    + "inner join c1.address as c3 "
                    + "inner join c3.cityinfo as c4 "
                    + "where c2.number = :phone", PersonDTO.class);
            query.setParameter("phone", number);
            List<PersonDTO> list = query.getResultList();
            return list;
        } finally {
            em.close();
        }
    }
    
    public List<PersonDTO> findPersonsWithGivenHobby(String hobbyname){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<PersonDTO> query = em.createQuery("select new dto.PersonDTO(c1.id, c1.email, c1.firstName, c1.lastName)"
                    + " from Person c1 inner join c1.hobbys as c2"
                    + " where c2.name = :hobby", PersonDTO.class);
            query.setParameter("hobby", hobbyname);
            List<PersonDTO> list = query.getResultList();
            return list;
        }finally{
            em.close();
        }
    }
    
    public List<PersonDTO> findPersonsWithGivenCity(String cityname){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<PersonDTO> query = em.createQuery("select new dto.PersonDTO(c1.id, c1.email, c1.firstName, c1.lastName)"
                    + " from Person c1 inner join c1.address as c2"
                    + " inner join c2.cityinfo as c3"
                    + " where c3.city = :city", PersonDTO.class);
            query.setParameter("city", cityname);
            List<PersonDTO> list = query.getResultList();
            return list;
        }finally{
            em.close();
        }
    }
    
    public Long getCountOfPeopleWithGivenHobby(String hobbyname){
        EntityManager em = getEntityManager();
        try{
            Query query = em.createQuery("Select count(c) from Person c inner join c.hobbys as c1 where c1.name = :hobby");
            query.setParameter("hobby", hobbyname);
            return (Long) query.getSingleResult();
        }finally{
            em.close();
        }
    }
    
    public List<CityInfoDTO> getAllZipCodes(){
        EntityManager em = getEntityManager();
        try{
            TypedQuery<CityInfoDTO> query = em.createQuery("Select new dto.CityInfoDTO(c.city, c.zip) from CityInfo c", CityInfoDTO.class);
            List<CityInfoDTO> list = query.getResultList();
            return list;
        }finally{
            em.close();
        }
    }
    
}
