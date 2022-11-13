package jobScheulerSimilarToAirflow;

public class Driver {
    public static void main(String[] args) {
        SchedulerService schedulerService = SchedulerService.getInstance();

        Job j1= new Job(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ "hi I am task 1");
            }
        });
        Job j2= new Job(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ "hi I am task 2");
            }
        });
        Job j3= new Job(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+ "hi I am task 3");
            }
        });

        schedulerService.schedule(j1, System.currentTimeMillis()+1000);
        schedulerService.schedule(j2, System.currentTimeMillis()+10000);
        schedulerService.schedule(j3, System.currentTimeMillis()+1000000);


    }
}
