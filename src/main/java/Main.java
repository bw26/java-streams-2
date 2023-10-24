import Model.Car;
import Model.Person;
import Repo.DataRepo;
import Model.CarRecord;
import Model.EngineRecord;

import java.util.Arrays;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
    }

    private static void ex1() {
        // TODO...
        var peopleList = DataRepo.getPeople();
        var retList = peopleList.stream();
        // TODO...
        retList = retList.filter((person) -> person.getAge()>30);
        System.out.println(retList.collect(Collectors.toList()));
    }

    private static void ex2() {
        // TODO...
        var peopleList = DataRepo.getPeople();
        var retList = peopleList.stream();
        System.out.println(retList.mapToDouble(person -> person.getAge()).average().getAsDouble());
    }

    private static void ex3() {
        // TODO...
    }

    private static void ex4() {
        // TODO...
    }

    private static void ex5() {
        // TODO...
    }

    private static void ex6() {
        // TODO...
    }

    private static void ex7() {
        // TODO...
    }

    private static void ex8() {
        // TODO...
    }

    private static void ex9() {
        // TODO...
    }
    private static void ex10() {
        // TODO...
    }
}
