package com.example.jobScheulerSimilarToAirflow;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {
    public static void main(String[] args) {
        SchedulerService schedulerService = SchedulerService.getInstance();

        Job j1= new Job(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " Running task 1");
            }
        },"1");
        Job j2= new Job(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " Running task 2");
            }
        },"2");
        Job j3= new Job(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " Running task 3");
            }
        },"3");
        Job j4= new Job(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " Running task 4");
            }
        },"4");
        Job j5= new Job(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " Running task 5");
            }
        },"5");
        Job j6= new Job(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ " Running task 6");
            }
        },"6");
        List<Job> jobs= Arrays.asList(new Job[]{j1, j2, j3, j4, j5, j6});
        ExecutorService executors = Executors.newFixedThreadPool(6);
        Random rand = new Random();
        for(int i=0;i<6;i++){
            int finalI = i;
            int delta = rand.nextInt(10000);
            long startTime= System.currentTimeMillis()+delta;
            executors.execute(() -> schedulerService.schedule(jobs.get(finalI), startTime));

        }
        executors.shutdown();





    }
}
