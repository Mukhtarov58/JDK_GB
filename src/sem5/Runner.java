package sem5;

import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{
    private String name;
    private CountDownLatch cdl;

    public Runner(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
    }

    public void goToStart() throws InterruptedException {
        System.out.println(this.name + "- go to start");
        Thread.sleep((long) (Math.random()*3000L));
        System.out.println(this.name + " - on start");
        cdl.countDown();
    }

    public void goToFinish() throws InterruptedException {
        System.out.println(this.name + "- start go to finish");
        Thread.sleep((long) (Math.random()*3000L));
        System.out.println(this.name + " - on finish");
    }


    @Override
    public void run() {
        try {
            goToStart();
            cdl.await();
            goToFinish();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}