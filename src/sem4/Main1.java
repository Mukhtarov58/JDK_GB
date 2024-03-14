package sem4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/*
В рамках выполнения задачи необходимо:
1. Создайте коллекцию мужских и женских имен с помощью интерфейса List
2. Отсортируйте коллекцию в алфавитном порядке
3. Отсортируйте коллекцию по количеству букв в слове
4. Разверните коллекцию
 */
public class Main1 {
    public static void main(String[] args) {
        List<String> names = createListNames();
        System.out.println(names);
        System.out.println(sortByAlphabet(names));
        System.out.println(sortByLengthLine(names));
        System.out.println(reverseList(names));
    }

    private static List<String> sortByAlphabet(List<String> list){
//        list.sort((e1, e2) -> e1.compareTo(e2));
//        return list;

        return list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    private static List<String> sortByLengthLine(List<String> list){
//        list.sort((e1, e2) -> e1.length() - e2.length());
//        return list;

        return list.stream().sorted((e1, e2) -> e1.length() - e2.length()).collect(Collectors.toList());
    }

    private static List<String> reverseList(List<String> list){
//        for (int i = 0; i < list.size() / 2; i++) {
//            String temp = list.get(i);
//            list.set(i, list.get(list.size() - 1 - i));
//            list.set(list.size() - 1 - i, temp);
//        }
//        return list;

        Collections.reverse(list);
        return list;
    }

    private static List<String> createListNames(){
        List<String> list = new ArrayList<>();
        list.add("Костя");
        list.add("Василий");
        list.add("Семен");
        list.add("Кирилл");
        list.add("Артем");
        list.add("Сергей");

        return list;
    }
}
