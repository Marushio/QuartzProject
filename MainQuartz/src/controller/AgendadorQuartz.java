package controller;
//importações necessarias para ultilizar as funçoes do quartz
import static org.quartz.CronScheduleBuilder.cronSchedule;
import org.quartz.Job;
import static org.quartz.JobBuilder.newJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import static org.quartz.TriggerBuilder.newTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class AgendadorQuartz {
    public void agendarJob(Class<? extends Job> CalssJob,int segundos)throws SchedulerException{
        //InterruptedException
            System.out.println("Erro ao sdfdfdfde con");
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler sched = sf.getScheduler();
            JobDetail job = newJob(CalssJob)
            .withIdentity("job1", "group1")
            .build();
            
            Trigger trigger = newTrigger()
            .withIdentity("trigger1", "group1")
            .withSchedule(cronSchedule("0/"+segundos+" * * * * ?"))
            .build();
            sched.scheduleJob(job, trigger);
            sched.start();
            
           // sched.shutdown(true);
         
    }    
}
