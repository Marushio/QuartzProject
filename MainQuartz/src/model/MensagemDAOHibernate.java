/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import controller.Mensagem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.ejb.EntityManagerFactoryImpl;

/**
 *
 * @author a1320726
 */
public class MensagemDAOHibernate {
    public void inserir(Mensagem mensagem)throws Exception{
        EntityManager em = HibernateEntityManagerFactory.getEntityManager();
          
        try{
            em.getTransaction().begin();
            em.persist(mensagem);
            em.getTransaction().commit();
        }
        finally{
            if(em != null){
                em.close();
            }
        }
        
        
    }
    public void ApagarMensagens() throws SQLException{
        EntityManager em = HibernateEntityManagerFactory.getEntityManager();
          
        try{
            em.getTransaction().begin();
            Query q = em.createQuery("delete object(m) from Mensagem as m ");
            q.executeUpdate();
            em.getTransaction().commit();
        }
        finally{
            if(em != null){
                em.close();
            }
        }
    }
    
    public List obterMensagens()throws Exception{
        EntityManager em = HibernateEntityManagerFactory.getEntityManager();
        List mensagens =  null;
        try{
            Query q = em.createQuery("select object(m) from Mensagem as m ");
            mensagens=q.getResultList();
            
        }finally{
            if(em != null){
                em.close();
            }
        }    
    return mensagens;
            
    }
}
