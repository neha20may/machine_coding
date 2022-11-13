package com.example.jobScheulerSimilarToAirflow;

import java.util.Queue;
import java.util.concurrent.ExecutorService;

public class SchedulerWorker implements Runnable {
    Queue<Job> minHeap;
    ExecutorService threadPool;

    public SchedulerWorker(Queue<Job> minHeap, ExecutorService threadPool) {
        this.minHeap = minHeap;
        this.threadPool = threadPool;
    }

    @Override
    public void run() {
        while (true) {
            long waitTime = 0;
            Job next = null;
            synchronized (minHeap) {
                if (!minHeap.isEmpty()) {
                    next = minHeap.peek();
                    waitTime = next.getStartTime() - System.currentTimeMillis();
                }
                else {
                   continue;
                }
            }


            if (waitTime > 0) {
                try {
                    System.out.println(Thread.currentThread().getName()+ " job "+next.getJobId()+" has wait time of "+waitTime +" so gonna sleep for that time");
                    Thread.currentThread().sleep(waitTime);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "got interrupted");
                    continue;
                }
            }
            if (next != null) { //check needed for starting when there is no job in the heap
//                Thread worker = new Thread(next.getTask());
                System.out.println(Thread.currentThread().getName() + " starting the job " + next.getJobId() + " at " + System.currentTimeMillis());
//                worker.start();
                threadPool.execute(next.getTask());
            }

            synchronized (minHeap) {
                if (minHeap.peek() == next)
                    minHeap.poll();
                else
                    minHeap.remove(next);
            }
        }
    }
}
