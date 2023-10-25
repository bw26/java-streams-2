import Model.*;
import Repo.DataRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.text.NumberFormat;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
        ex6();
        ex7();
        ex8();
        ex9();
        ex10();
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
        var catList = DataRepo.getCats();
        var retList = catList.stream();
        System.out.println(retList.filter(cat -> cat.getColor().equals("Brown")).sorted((c1,c2) -> c1.getAge().compareTo(c2.getAge())).
                collect(Collectors.toList()));
    }

    private static void ex4() {
        // TODO...
        Integer[] numbers = new Integer[] { 1, 2, 3, 1, 2, 3, 4};
        System.out.println(Arrays.stream(numbers).distinct().collect(Collectors.toList()));
    }

    private static void ex5() {
        // TODO...
        var engine = DataRepo.getCarsWithEngines();
        System.out.println(engine.stream().filter(car -> car.getEngine().getNumCylinders()>=8).count());
    }

    private static void ex6() {
        // TODO...
        var peopleList = DataRepo.getPeople();
        System.out.println(peopleList.stream().map(person -> person.getFirstName().toUpperCase()).collect(Collectors.toList()));
    }

    private static void ex7() {
        // TODO...
        var cars = DataRepo.getCars();
        var carRecords = cars.stream().filter(car -> car.getPrice()>20000).map(car -> new CarRecord(car.getId(),car.getMake(),car.getModel(),NumberFormat.getCurrencyInstance().format(car.getPrice())));
        System.out.println(carRecords.collect(Collectors.toList()));
    }

    private static void ex8() {
        // TODO...
        var carList = DataRepo.getCars();
        var peopleList = DataRepo.getPeople();
        System.out.println(peopleList.stream().map(person -> carList.stream().filter(car -> car.getId().equals(person.getCarId())).map(car -> car.getModel()).collect(Collectors.joining())).collect(Collectors.toList()));
    }

    private static void ex9() {
        // TODO...
        var carList = DataRepo.getCarsWithEngines();
        var engineRecords = carList.stream().map(car -> new EngineRecord(car.getEngine().getNumCylinders(), car.getEngine().getDisplacment(),(car.getEngine().getNumCylinders()>=8)? car.getEngine().getDisplacment()*100 : 0)).collect(Collectors.toList());
        System.out.println(engineRecords);
    }
    private static void ex10() {
        // TODO...
        var carList = DataRepo.getCarsWithEngines();
        var retList = carList.stream().map(car -> new CarRecord(car.getId(),car.getMake(),car.getModel(),NumberFormat.getCurrencyInstance().format(car.getPrice()+((car.getEngine().getNumCylinders()>=8)? car.getEngine().getDisplacment()*100 : 0)))).collect(Collectors.toList());
        System.out.println(retList);
    }
}
