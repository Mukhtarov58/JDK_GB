package sem4;

import java.util.*;
//В рамках выполнения задачи необходимо:
//Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
//Получите уникальный список Set на основании List
//Определите наименьший элемент (алфавитный порядок)
//Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
//Удалите все элементы содержащие букву ‘A’
public class Main2 {
    public static void main(String[] args) {
        Set<String> names = createNames();
        System.out.println(names);
        System.out.println(findMinAlphavet(names));
        System.out.println(findMaxLength(names));
        System.out.println(remove('А', names));
        System.out.println(removeWithStream('о', names));
    }

    public static Set<String> createNames(){
        List<String> list = new ArrayList<>();
        list.add("Костя");
        list.add("Василий");
        list.add("Семен");
        list.add("Кирилл");
        list.add("Артем");
        list.add("Сергей");
        list.add("Василий");

        return new HashSet<>(list);
    }

    public static String findMinAlphavet(Set<String> set){
        return set.stream().min(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        }).orElse(null);
    }

    public static String findMaxLength(Set<String> set){
        return set.stream().max(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }).orElse(null);
    }

    public static Set<String> remove(char deleteSymbol, Set<String> set){
        Set<String> clearSet = new HashSet<>();
        for (String elem : set) {
            if(!elem.contains(Character.toString(deleteSymbol))){
                clearSet.add(elem);
            }
        }

        return clearSet;
    }

    public static Set<String> removeWithStream(char deleteSymbol, Set<String> set){
        set.removeIf(x -> x.contains(Character.toString(deleteSymbol)));
        return set;
    }
}