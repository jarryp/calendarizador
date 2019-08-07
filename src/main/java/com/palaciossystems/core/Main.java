package com.palaciossystems.core;

import java.util.Date;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.SimpleTriggerImpl;

public class Main {

	public static void main(String[] args) throws SchedulerException {
		JobDetailImpl jd = new JobDetailImpl();
		jd.setName("MyJobDetail");
		jd.setJobClass(MyJob.class);
		
		SimpleTriggerImpl st = new SimpleTriggerImpl();
		st.setName("MyTrigger");
		st.setStartTime(new Date(System.currentTimeMillis()));
		st.setRepeatInterval(3000);
		st.setRepeatCount(5);
		
		Scheduler sd = new StdSchedulerFactory().getScheduler();
		sd.scheduleJob(jd, st);
		sd.start();

	}

}
