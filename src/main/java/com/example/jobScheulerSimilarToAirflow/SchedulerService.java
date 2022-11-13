package com.example.jobScheulerSimilarToAirflow;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SchedulerService {
    private static SchedulerService object = new SchedulerService(2);

    public static SchedulerService getInstance() {
        return object;
    }

    public Queue<Job> minHeap;
    Thread schedulerWorkerThread;
    ExecutorService threadPool;

    SchedulerService(int threadCount) {
        minHeap = new PriorityQueue<Job>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if (o1.getStartTime() > o2.getStartTime())
                    return 1;
                else
                    return 0;
            }
        });
        threadPool= Executors.newFixedThreadPool(threadCount);
        /**
         * this class is singleton hence there is one SchedulerWorker running.
         */
        schedulerWorkerThread = new Thread(new SchedulerWorker(minHeap, threadPool));

        schedulerWorkerThread.start();
    }

    void addToQueue(Job j, long startTime) {
        j.setStartTime(startTime);

        synchronized (minHeap) {
            System.out.println("Thread " + Thread.currentThread().getName() + " adding the job Id: " + j.getJobId() + " to queue with startTime "+startTime);
            minHeap.add(j);
        }
        if (minHeap.peek() == j) {
            System.out.println("This is the top job in the heap, gonna interupt the scheduler worker thread");
            schedulerWorkerThread.interrupt();
        }
        /**
         * Note: this class is producer ; which keeps the items in queue and the scheduler worker class is consumer.
         * so you might as well use the wait signal and lock condition here for any spurious interrupts or so.
         */

    }

    public void schedule(Job j1, long startTime) {
        addToQueue(j1, startTime);

    }

    public void stop() {
        System.out.println("shutting down the thread pool of workers");
        threadPool.shutdown();
    }
}
