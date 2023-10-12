package lesson_33._04_stream_usage;

import lesson_33._04_stream_usage.model.Chicken;
import lesson_33._04_stream_usage.model.ChickenComparator;
import lesson_33._04_stream_usage.model.Dog;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Dog> dogs = List.of(
                new Dog("Tuzik", 2),
                new Dog("Bobik", 7),
                new Dog("Pushok", 5),
                new Dog("Rex", 3)
        );

        List<Chicken> chiks = List.of(
                new Chicken("Grill", 5),
                new Chicken("Fried", 7),
                new Chicken("Boiled", 5),
                new Chicken("Grill", 5)
        );

        Stream<Dog> dogStream = dogs.stream()
                .filter(dog -> dog.getAge() >= 3)
                .filter(dog -> dog.getName().length() >= 5);
        dogStream.forEach(System.out::println);

        System.out.println("------------------------------");

        dogs.stream()
                .map(Dog::getName)
                .forEach(System.out::println);

        System.out.println("------------------------------");

        dogs.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------------------");

        chiks.stream()
                .sorted(new ChickenComparator())
                .forEach(System.out::println);

        System.out.println("------------------------------");

        Stream<String> dogsObj = dogs.stream().map(Dog::getName);
        Stream<String> chicksObj = chiks.stream().map(Chicken::getName);
        Stream.concat(dogsObj, chicksObj).forEach(System.out::println);

        System.out.println("------------------------------");

        chiks.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("------------------------------");

        dogs.stream()
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
    }
}
