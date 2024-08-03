package com.mikehans.collections;

import java.time.LocalDate;

public record Weirdo(String lastName, String firstName, LocalDate dob) implements Apple {
    public Weirdo(String lastName, String firstName) {
        this(lastName, firstName, null);
    }

    public String sayHello() {
        return "Hello World";
    }
}

