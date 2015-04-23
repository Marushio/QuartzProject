package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateEntityManagerFactory {
     private static EntityManagerFactory emf = null;
     private HibernateEntityManagerFactory (){
         
     }
     public static EntityManager getEntityManager(){
         try{
             if(emf == null)
                  emf = Persistence.createEntityManagerFactory("chat");
             
                  return emf.createEntityManager();
          //caso exusta erro na conficguração de conecção com o banco omo tabela nao extes, nao consegue conecat na porta etc   
         }catch(Exception e){
             e.printStackTrace();
         }
         return null;
     }
         
     
}
