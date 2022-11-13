package jobScheulerSimilarToAirflow;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SchedulerService {
    private static SchedulerService object= new SchedulerService();
    public static SchedulerService getInstance() {
        return  object;
    }
    public Queue<Job> minHeap;
    Thread schedulerWorkerThread;
    SchedulerService(){
        minHeap = new PriorityQueue<Job>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.getStartTime() <o2.getStartTime())
                    return  1;
                else
                    return  0;
            }
        });
        schedulerWorkerThread = new Thread(new SchedulerWorker(minHeap));
    }

    void addToQueue(Job j, long startTime){
        j.setStartTime(startTime);
        synchronized (minHeap){
            minHeap.add(j);
        }
        if(minHeap.peek() == j){
            schedulerWorkerThread.interrupt();
        }

    }

    public void schedule(Job j1, long startTime) {
        addToQueue(j1, startTime);

    }
}
