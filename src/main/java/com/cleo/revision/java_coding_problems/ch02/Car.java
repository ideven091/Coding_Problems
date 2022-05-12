package com.cleo.revision.java_coding_problems.ch02;

import java.awt.*;
import java.util.Objects;

public class Car {

    private final String name;
    private final Color color;

    public Car(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public void assignDriver(String license, Point location){
        Objects.requireNonNull(license, "Driver's license cannot be null");
        Objects.requireNonNull(location, "Start location cannot be null");
    }
}
