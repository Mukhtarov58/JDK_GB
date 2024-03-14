package sem4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

//В рамках выполнения задачи необходимо:
//    1. Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
//    2. Найдите человека с самым маленьким номером телефона
//    3. Найдите номер телефона человека чье имя самое большое в алфавитном порядке
public class Main3 {
    public static void main(String[] args) {
        Map<String,String> map = createMap();
        System.out.println(findMostShorterNumber(map));
        System.out.println(findNumberByName(map));
        System.out.println(findNumberByNameV2(map));

    }

    public static Map<String,String> createMap(){
        Map<String,String> map = new HashMap<>();
        map.put("10","Name1");
        map.put("2","Name22");
        map.put("3","Name33");
        map.put("4","Name4");
        map.put("5","Zame5");
        map.put("6","Ame6");
        return map;
    }

    public static String findMostShorterNumber(Map<String,String> map){
        //return map.keySet().stream().min((e1,e2) -> Integer.parseInt(e1) - Integer.parseInt(e2))
        return map.keySet().stream().min(Comparator.comparingInt(Integer::parseInt))
                .orElse(null);
    }

    public static String findNumberByName(Map<String,String> map){

        String temp = "A";
        String key = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if(temp.compareTo(entry.getValue()) < 0 ){
                temp = entry.getValue();
                key = entry.getKey();
            }
        }
        return key + ": " + temp;
    }

    public static String findNumberByNameV2(Map<String,String> map){
        return map.entrySet()
                .stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).get().getKey();
    }
}