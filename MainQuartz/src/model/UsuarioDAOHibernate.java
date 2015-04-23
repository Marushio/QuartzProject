/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author a1320726
 */
public class UsuarioDAOHibernate {
    
        public void InserirUsuario(Usuario user)throws Exception{
            EntityManager em = HibernateEntityManagerFactory.getEntityManager();
          
        try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }  
    public Usuario obterUsuario(String login)throws Exception{
        Usuario user = null;
        EntityManager em = HibernateEntityManagerFactory.getEntityManager();

       try{
           Query q= em.createQuery("select object(o)from Usuario as o where login = '"+login +"'");
           user = (Usuario) q.getSingleResult();
       }finally{
           if(em != null)
              em.close();
       }
       return user;
    }   
}
