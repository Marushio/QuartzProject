
package controller;

import java.sql.SQLException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import model.MensagemDAOHibernate;

/**
 *
 * @author Marcio
 */
public class JobApagar implements Job{
    
    
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        MensagemDAOHibernate mensagemDAOHibernate;
        mensagemDAOHibernate = new MensagemDAOHibernate();
        try{
            
            mensagemDAOHibernate.ApagarMensagens();
        }catch(SQLException sqle){
            System.out.println("Erro ao se conectar ao banco de dados."+sqle.getStackTrace());
        } 
    }
    
}
