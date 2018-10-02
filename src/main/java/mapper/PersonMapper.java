package mapper;

import dto.PersonDTO;
import entity.CityInfo;
import entity.Person;
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

    public PersonDTO findPersonFromPhoneNumber(int number) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<PersonDTO> query = em.createQuery("select new dto.PersonDTO(c1.id, c1.email, c1.firstName, c1.lastName,"
                    + " c2.name, c2.description,"
                    + " c3.number, c3.description,"
                    + " c4.street, c4.additionalInfo,"
                    + " c5.zip, c5.city) from Person c1 inner join c1.hobbys as c2"
                    + " inner join c1.phones as c3"
                    + " inner join c1.address as c4"
                    + " inner join c4.cityinfo as c5"
                    + " where c1.phones.number = :phone", PersonDTO.class);
            query.setParameter("phone", number);
            return (PersonDTO) query.getSingleResult();
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
    
    public Integer getCountOfPeopleWithGivenHobby(String hobbyname){
        EntityManager em = getEntityManager();
        try{
            Query query = em.createQuery("Select count(c) from Person c where c.hobbys.name = :hobby");
            query.setParameter("hobby", hobbyname);
            return (Integer) query.getSingleResult();
        }finally{
            em.close();
        }
    }
    
    public List<Integer> getAllZipCodes(){
        EntityManager em = getEntityManager();
        try{
            Query query = em.createQuery("Select c.zip from CityInfo c");
            List<Integer> list = query.getResultList();
            return list;
        }finally{
            em.close();
        }
    }
}
