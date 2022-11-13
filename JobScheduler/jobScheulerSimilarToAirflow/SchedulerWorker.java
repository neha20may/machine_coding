package jobScheulerSimilarToAirflow;

import java.util.Queue;

public class SchedulerWorker implements Runnable {
    Queue<Job> minHeap;

    public SchedulerWorker(Queue<Job> minHeap) {
        this.minHeap = minHeap;
    }

    @Override
    public void run() {
        while (true) {
            Job next = null;
            synchronized (minHeap) {
                if (!minHeap.isEmpty()) {
                    next = minHeap.peek();
                }
            }
            long waitTime = next.getStartTime() - System.currentTimeMillis();
            if (waitTime > 0) {
                try {
                    Thread.currentThread().sleep(waitTime);
                } catch (InterruptedException e) {
                    continue;
                }
            }
            Thread worker = new Thread(next.getTask());
            worker.start();

            synchronized (minHeap) {
                if (minHeap.peek() == next)
                    minHeap.poll();
                else
                    minHeap.remove(next);
            }
        }
    }
}
