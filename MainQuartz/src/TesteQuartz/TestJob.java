/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteQuartz;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author Marcio
 */
public class TestJob implements Job{
     

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        System.out.println( new Date() );
    }
}