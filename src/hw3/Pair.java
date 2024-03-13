package hw3;
/*
Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
Класс должен иметь методы getFirst(), getSecond() для получения значений каждого из
составляющих пары, а также переопределение метода toString(),
возвращающее строковое представление пары. Работу сдать в виде ссылки на гит репозиторий.
 */
public class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>(1, "One");
        Pair<Double, Integer> pair2 = new Pair<>(3.14, 42);

        System.out.println(pair1);
        System.out.println(pair1.getFirst());
        System.out.println(pair1.getSecond());

        System.out.println(pair2);
        System.out.println(pair2.getFirst());
        System.out.println(pair2.getSecond());
    }
}
