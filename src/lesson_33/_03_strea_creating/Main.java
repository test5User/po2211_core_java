package lesson_33._03_strea_creating;

import lesson_33._01_intro_lambdas.model.Cat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //пустой стрим
        Stream<Object> empty = Stream.empty();
        //из коллекции (лист)
        List<Integer> ints = List.of(1,2,3);
        Stream<Integer> stream = ints.stream();
        //из коллекции (мапа)
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "a");
        map.put(2, "b");
        Stream<Map.Entry<Integer, String>> stream1 = map.entrySet().stream();
        //из массива
        Stream<String> stream2 = Arrays.stream(new String[]{"a", "b"});
        //из элементов
        Stream<Integer> integerStream = Stream.of(1, 2, 4);
    }
}
