package hw5;

public class Philosopher extends Thread {
    private final int id;
    private final Object leftFork;
    private final Object rightFork;
    private int mealsEaten;

    public Philosopher(int id, Object leftFork, Object rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.mealsEaten = 0;

    }

    @Override
    public void run() {
        try {
            while (mealsEaten < 3) {
                think();
                eat();
                mealsEaten++;
            }
            System.out.println("философ " + id + " закончил кушать.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " думает");
        Thread.sleep((long) (Math.random() * 1000L));
    }

    private void eat() throws InterruptedException {
        synchronized (leftFork) {
            System.out.println("Философ " + id + " взял левую вилку");
            synchronized (rightFork) {
                System.out.println("Философ " + id + " взял правую вилку");
                System.out.println("Философ " + id + " ест");
                Thread.sleep((long) (Math.random() * 1000L));
                System.out.println("Философ " + id + " опустить правую вилку");
            }
            System.out.println("Философ " + id + " опустить левую вилку");
        }
    }
}

