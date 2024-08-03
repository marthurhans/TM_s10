package com.mikehans.collections;

public interface Chef {

    String favoriteFood = "hamburger";

    default void cook(String food) {
        System.out.println("I am now cooking " + food);
    }

    default String cleanUp() {
        return "I'm done cleaning up";
    }

    static int convertUnits() {
        return 0;
    }
}
