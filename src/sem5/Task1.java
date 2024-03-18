package sem5;
/*
 В рамках выполнения задачи необходимо:
 Создать два класса ObjectA, ObjectB
 Реализовать класс в котором два потока при запуске провоцируют DeadLock для объектов ObjectA, ObjectB
  */
public class Task1 {
    public static void main(String[] args) {

        ObjectA objectA = new ObjectA();
        ObjectB objectB = new ObjectB();


        Thread thread1 = new Thread(() -> {
            synchronized (objectA) {
                System.out.println("Поток 1 заблокировал А");
                synchronized (objectB) {
                    System.out.println("Поток 1 заблокировал B");
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (objectB) {
                System.out.println("Поток 2 заблокировал А");
                synchronized (objectA) {
                    System.out.println("Поток 2 заблокировал B");
                }
            }
        });
        thread1.start();
        thread2.start();
    }

}