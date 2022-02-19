package functional.streams;

import java.util.List;
import java.util.function.Predicate;

import static functional.streams._iStream.Gender.MALE;
import static functional.streams._iStream.Gender.FEMALE;
import static functional.streams._iStream.Gender.PREFER_NOT_TO_SAY;

public class _iStream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Ahmed", MALE),
                new Person("Shahin", FEMALE),
                new Person("Alina", FEMALE),
                new Person("Svetlana", MALE),
                new Person("Amiral", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

//        people.stream()
//                .map(person -> person.name)
//                .mapToInt(String::length)
//                .forEach(System.out::println);

//        people.stream()
//                .map(person -> person.gender)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                .noneMatch(personPredicate);

    }


    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
