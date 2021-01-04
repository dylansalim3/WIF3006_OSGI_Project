package com.fitness.bmi;

public interface BmiInterface {
    double getBMI(double mass, double height);
    String getCategory(double initialBmi);
}
