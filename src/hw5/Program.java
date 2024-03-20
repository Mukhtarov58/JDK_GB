package hw5;
/*
Обед философов.
5 философов кушают лапшу из 1 чашки, которая стоит в средине круглого стола.
Каждый философ должен поесть 3 раза, когда философ не ест, он думает.
Между философами лежат вилки и кушать может философ только когда у него 2 вилки в руках.
 */
public class Program {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[5];

        for (int i = 0; i < 5; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < 5; i++) {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % 5]);
            philosophers[i].start();
        }
    }
}
