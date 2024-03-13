package hw3;

import java.util.Objects;
/*
Напишите обобщенный метод compareArrays(), который принимает два массива и возвращает true,
если они одинаковые, и false в противном случае. Массивы могут быть любого типа данных,
но должны иметь одинаковую длину и содержать элементы одного типа по парно по индексам.
 */
public class ArrayComparator {
    public static <T1, T2> boolean compareArrays(T1[] array1, T2[] array2) {
        if (array1.length != array2.length) return false;
        for (int i = 0; i < array1.length; i++) {
            if (!Objects.equals(array1[i].getClass(), array2[i].getClass())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4, 5};
        Double[] array2 = {1.0, 2.0, 3.0, 4.0, 5.0};
        Integer[] array3 = {1, 2, 6, 4, 5};

        System.out.println(compareArrays(array1, array2));
        System.out.println(compareArrays(array1, array3));
    }

}
