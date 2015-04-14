
package controller;

import java.sql.SQLException;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import model.MensagemDAO;

/**
 *
 * @author Marcio
 */
public class JobApagar implements Job{
    
    
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        MensagemDAO mensagemDAO;
        mensagemDAO = new MensagemDAO();
        try{
            
            mensagemDAO.ApagarMensagens();
        }catch(SQLException sqle){
            System.out.println("Erro ao se conectar ao banco de dados, 5 "+sqle.getStackTrace());
        } 
    }
    
}
