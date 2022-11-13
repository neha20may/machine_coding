package jobScheulerSimilarToAirflow;

public class Job {
    Runnable task;

    public long getStartTime() {
        return startTime;
    }

    long startTime;

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public Job(Runnable task) {
        this.task = task;
    }

    public Runnable getTask() {
        return task;
    }

    public void setTask(Runnable task) {
        this.task = task;
    }
}
