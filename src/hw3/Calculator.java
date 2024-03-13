package hw3;

/*
Написать класс Калькулятор (необобщенный), который содержит обобщенные статические
методы: sum(), multiply(), divide(), subtract().
Параметры этих методов – два числа разного типа, над которыми должна быть произведена операция.
Методы должны возвращать результат своей работы.
 */
public class Calculator {
    public static <T extends Number> double sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number> double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number> double divide(T num1, T num2) {
        if (num2.doubleValue() == 0) {
            throw new ArithmeticException("На ноль делить нельзя!");
        }
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <T extends Number> double subtract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }

    public static void main(String[] args) {
        int num1 = 5;
        double num2 = 3.14;

        System.out.println("Sum: " + sum(num1, num2));
        System.out.println("Multiply: " + multiply(num1, num2));
        System.out.println("Divide: " + divide(num1, num2));
        System.out.println("Subtract: " + subtract(num1, num2));
    }

}
