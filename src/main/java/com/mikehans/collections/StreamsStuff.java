package com.mikehans.collections;

import java.util.Optional;
import java.util.function.Predicate;

public class StreamsStuff {

    public static void main(String[] args) {
        String peopleText = """
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            Flinstone, Fred, 1/1/1900, Programmer, {locpd=2000,yoe=10,iq=140}
            
            Flinstone2, Fred2, 1/1/1900, Programmer, {locpd=1300,yoe=14,iq=100}
            Flinstone3, Fred3, 1/1/1900, Programmer, {locpd=2300,yoe=8,iq=105}
            Flinstone4, Fred4, 1/1/1900, Programmer, {locpd=1630,yoe=3,iq=115}
            Flinstone5, Fred5, 1/1/1900, Programmer, {locpd=5,yoe=10,iq=100}
            Rubble, Barney, 2/2/1905, Manager, {orgSize=300,dr=10}
            Rubble2, Barney2, 2/2/1905, Manager, {orgSize=100,dr=4}
            Rubble3, Barney3, 2/2/1905, Manager, {orgSize=200,dr=2}
            Rubble4, Barney4, 2/2/1905, Manager, {orgSize=500,dr=8}
            Rubble5, Barney5, 2/2/1905, Manager, {orgSize=175,dr=20}
            Flinstone, Wilma, 3/3/1910, Analyst, {projectCount=3}
            Flinstone2, Wilma2, 3/3/1910, Analyst, {projectCount=4}
            Flinstone3, Wilma3, 3/3/1910, Analyst, {projectCount=5}
            Flinstone4, Wilma4, 3/3/1910, Analyst, {projectCount=6}
            Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}
            Rubble, Betty, 4/4/1915, CEO, {aveStockPrice=300}
            """;

        Predicate<Employee> dummySelector = e -> e.getLastName().equals("N/A");
        Optional<Employee> optionEmp = peopleText
//        boolean allOver3k = peopleText
                .lines()
                .map(Employee::createEmployee)
                .map(e -> (Employee)e)
                .filter(dummySelector.negate())
                .filter(e -> e.getSalary() < 0)
                .findFirst();
        System.out.println(optionEmp
                .map(Employee::getFirstName)
                .orElse("Nobody"));
//                .noneMatch(e -> e.getSalary() < 0);
//        System.out.println(allOver3k);
//                .map(Employee::getFirstName)
//                .map(firstName -> firstName.split(""))
//                .flatMap(Arrays::stream)
//                .map(String::toLowerCase)
//                .distinct()
//                .forEach(System.out::print);


//        try {
//            Files.lines(Path.of("C:\\Users\\lilci\\INTELLIJ\\MARTIN FUNDAMENTALS\\Section_9_Collections\\untitled\\src\\main\\java\\com\\mikehans\\collections\\employees.txt"))
//                    .forEach(System.out::println);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

//        int sum = peopleText
//                .lines()
//                .map(Employee::createEmployee)
//                .mapToInt(IEmployee::getSalary)
//                .sum();
//        System.out.println(sum);

//        int sum = peopleText
//                .lines()
//                .map(Employee::createEmployee)
//                .mapToInt(e -> {
//                    System.out.println(e);
//                    return e.getSalary();
//                })
//                .sum();
//        System.out.println(sum);
        //Adding a comment just to commit a git push test

//        Predicate<Employee> dummyEmpSelector = (employee -> "N/A".equals(employee.getLastName()));
//        Predicate<Employee> overFiveKSelector = e -> e.getSalary() > 5000;
//        int sum2 = peopleText
//                .lines()
////                .filter(not(s -> s.contains("Programmerzzzzz")))
////                .filter(((Predicate<String>)  s -> s.contains("Programmerzzzzz")).negate())
//                .map(Employee::createEmployee)
//                .map(e -> (Employee) e)
//                .filter(dummyEmpSelector.negate().and(overFiveKSelector))
////                .distinct()
////                .filter(not(e -> e.getLastName().equals("N/A")))
////                .filter(not(e -> e instanceof Programmer))
////                .filter((e -> e.getSalary() > 5000))
////                .filter((e -> e.getSalary() < 10000))
//                .collect(Collectors.toSet()).stream()
//                .sorted(comparing(Employee::getLastName)
//                            //The lambda version:
//                            //(x,y) ->x.getLastName().compareTo(y.getLastName())
//                        .thenComparing(Employee::getFirstName)
//                        .thenComparing(Employee::getSalary))
//                .mapToInt(StreamsStuff::showEmpAndGetSalary)
//                .sum();
//        System.out.println(sum2);

//                .forEach((String s) -> System.out.println(s));
//                .forEach(s -> System.out.println(s));

//        Stream.of("one", "two", "three", "four")
//                .map(String::hashCode)
//                .map(Integer::toHexString)
//                .forEach(System.out::println)
//        Stream.of(1,2,3,4)
//                .map(Integer::toHexString)
//                .forEach(System.out::println);
//
//
//        record Car(String make, String model) {
//        }
//
//        Stream.of(new Car("Ford", "Bronco"), new Car("Tesla", "X"),
//                        new Car("Tesla", "3"))
//                .filter(c -> "Tesla".equals(c.make))
//                .forEach(System.out::println);
//
//        String myVar = null;
//        Stream.ofNullable(myVar)
//                .forEach(System.out::println);
//
//        Stream.of(1,2,3,4); //Stream<Interger>
//
//        IntStream.of(1,2,3,4) //IntStream
//                .forEach(System.out::println);
//
//        IntStream.range(1, 6)
//                .forEach(System.out::println);
//
//        IntStream.rangeClosed(1, 5)
//                .mapToObj(String::valueOf)
//                .map(s -> s.concat("-"))
//                .forEach(System.out::println);
//
//        String[] names = {"joe", "bob", "nix"};
//        Arrays.stream(names)
//                .map(String::toUpperCase)
//                .forEach(System.out::println);
        //This is a comment added to test git/github
    }

    public static int showEmpAndGetSalary(IEmployee e) {
        System.out.println(e);
        return e.getSalary();
    }
}
