/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteQuartz;

import java.util.Date;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import org.quartz.DateBuilder;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Marcio
 */
public class SimpleExample {
    public static void main(String[] args)  {
         try {
        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler sched = sf.getScheduler();
        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloJob.class)
        .withIdentity("job1", "group1")
        .build();
        int segundos=20;
        // compute a time that is on the next round minute
       // Date runTime = DateBuilder.evenSecondDate(new Date(5000));
        // Trigger the job to run on the next round minute
        Trigger trigger = newTrigger()
                
        .withIdentity("trigger1", "group1")
        
        .withSchedule(cronSchedule("0/"+segundos+" * * * * ?"))  

       // .startAt(runTime)
        .build();
        // Tell quartz to schedule the job using our trigger
        sched.scheduleJob(job, trigger);
        sched.start();
        Thread.sleep(60L * 1000L);
        sched.shutdown(true);
        } catch (SchedulerException ex) {
            ex.printStackTrace();
        }
         catch (InterruptedException ie) {
            ie.printStackTrace();
        }

    }
}
