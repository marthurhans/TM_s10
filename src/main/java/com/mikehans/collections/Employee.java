package com.mikehans.collections;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Employee implements IEmployee {
    protected String lastName;
    protected String firstName;
    protected LocalDate dob;
    protected final Matcher peopleMat;
    protected final DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    protected static String PEOPLE_REGEX = "(?<lastName>\\w+),\\s*(?<firstName>\\w+)," +
            "\\s*(?<dob>\\d{1,2}/\\d{1,2}/\\d{4})," +
            "\\s*(?<role>\\w+)(?:,\\s*\\{(?<details>.*)\\})?";
    public static Pattern PEOPLE_PAT = Pattern.compile(PEOPLE_REGEX);
    protected final NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

    protected Employee() {
        peopleMat = null;
        lastName = "N/A";
        firstName = "N/A";
        dob = null;
    }

    protected Employee(String personText) {
        peopleMat = Employee.PEOPLE_PAT.matcher(personText);
        if (peopleMat.find()) {
            this.lastName = peopleMat.group("lastName");
            this.firstName = peopleMat.group("firstName");
            this.dob = LocalDate.from(dtFormatter.parse(peopleMat.group("dob")));
        }
    }

    //     Example of String we will input from main class:
//    "Flinstone5, Wilma5, 3/3/1910, Analyst, {projectCount=9}"
    public static IEmployee createEmployee(String employeeText) {
        Matcher peopleMat = Employee.PEOPLE_PAT.matcher(employeeText);
        if (peopleMat.find()) {
            return switch (peopleMat.group("role")) {
                case "Programmer" -> new Programmer(employeeText);
                case "Manager" -> new Manager(employeeText);
                case "Analyst" -> new Analyst(employeeText);
                case "CEO" -> new CEO(employeeText);
//              default -> new Employee(peopleMat.group());
                //BELOW: A SIMPLE LAMBDA
                //IT USES THE IEMPLOYEE CLASS
                //WHICH ONLY HAS ONE METHOD
                //WHICH MATCHES THE LAMBDA METHOD BELOW
                //IT READS: A METHOD THAT TAKES NO PARAMETERS AND RETURNS 0 (AN INT)
                //JAVA FIGURES OUT THAT THIS MATCHES THE METHOD IN IEMPLOYEE AUTOMATICALLY!
                default -> () -> 0;
                //anonymous class example (not using the lambda above)
//                        new Employee() {
//                @Override
//                public int getSalary () {
//                    return 0;
//                }
//            };
            };
        } else {
            return new DummyEmployee();
        }
    }
    public abstract int getSalary();
    //like an interface, its forcing any class that extends this one to have a getSalary() method

    public double getBonus() {
        return getSalary() * 1.10;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return String.format("%s, %s: %s - %s", lastName, firstName,
                moneyFormat.format(getSalary()), moneyFormat.format(getBonus()));
    }

    //NESTED CLASS
    private static final class DummyEmployee extends Employee implements IEmployee {
        @Override
        public int getSalary() {
            return 0;
        }
    }

    //NESTED CLASS
    private final class myInnerClass {
        public int getStuff() {
            System.out.println(firstName);
            return 0;
        }
    }


}

