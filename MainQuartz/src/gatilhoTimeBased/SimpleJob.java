/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gatilhoTimeBased;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 *
 * @author DiógenesGalileu
 */
class SimpleJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {  
        JobKey jobKey = context.getJobDetail().getKey();  
        System.out.println("SimpleJob says: " + jobKey + " executing at " + new Date());  
    }
}
