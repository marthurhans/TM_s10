package com.mikehans.collections;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class WeirdoMike {
    private String lastName;
    private String firstName;
    private LocalDate dob;

    public WeirdoMike() {
    }

    public WeirdoMike(String lastName, String firstName, LocalDate dob) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.dob = dob;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeirdoMike weirdo = (WeirdoMike) o;
        return Objects.equals(lastName, weirdo.lastName) && Objects.equals(firstName, weirdo.firstName) && Objects.equals(dob, weirdo.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, dob);
    }

    @Override
    public String toString() {
        return "CLASS - Weirdo: \n" +
                "\tlastName = '" + lastName + '\'' +
                "\n\tfirstName = '" + firstName + '\'' +
                "\n\tdob = " + dob +
                "";
    }

    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate weirdoDOB = LocalDate.parse("2/2/2022", dtf);
        WeirdoMike waldo = new WeirdoMike("Hell", "Yo", weirdoDOB);
        System.out.println(waldo);
        System.out.println(waldo.hashCode());
    }
}

