package lesson_33._05_terminal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> numbers = Stream.of(1,2,3,4,5,6);
        Optional<Integer> result = numbers.reduce((x, y) -> x + y);
        System.out.println("Result: " + result.get());

        Stream<Integer> numbers1 = Stream.of(-4,-3,-2, 2, 3, 4);
        int identity = 0;
        Integer result1 = numbers1.reduce(identity, Integer::sum);
        System.out.println("Result: " + result1);

        List<PricedCat> cats = List.of(
                new PricedCat("Cat1", 5, 500),
                new PricedCat("Cat2", 3, 400),
                new PricedCat("Cat3", 3, 600),
                new PricedCat("Cat4", 1, 800),
                new PricedCat("Cat5", 4, 650)
        );

        int amount = cats.stream()
                .reduce(0,
                        (x,y) -> {
                            if(y.getAge() < 3) {
                                return x + y.getPrice();
                            } else {
                                return x;
                            }
                        },
                        (x,y) -> x + y
                );
        System.out.println("Amount = " + amount);

        int integer = cats.stream()
                .filter(it -> it.getAge() < 3)
                .map(PricedCat::getPrice)
                .reduce(0, Integer::sum);
        System.out.println("Amount = " + integer);

        cats.stream()
                .filter(it -> it.getAge() < 3)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("______________________________");

        cats.stream()
                .filter(it -> it.getAge() >= 3)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println("______________________________");

        cats.stream()
                .collect(Collectors.toMap(k -> k.getName(), v -> v))
                .forEach((k,v) -> System.out.println(k + " - " + v));

        System.out.println("______________________________");

        LinkedList<PricedCat> collect = cats.stream()
                .collect(Collectors.toCollection(LinkedList::new));

    }

    private static class PricedCat {
        private String name;
        private int age;
        private int price;

        public PricedCat(String name, int age, int price) {
            this.name = name;
            this.age = age;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("PricedCat{");
            sb.append("name='").append(name).append('\'');
            sb.append(", age=").append(age);
            sb.append(", price=").append(price);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PricedCat pricedCat = (PricedCat) o;

            return age == pricedCat.age;
        }

        @Override
        public int hashCode() {
            return age;
        }
    }
}
