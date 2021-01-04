package com.fitness.calorie;

import java.io.Serializable;

import com.fitness.base.ExerciseLevel;

public class CalorieInputDto implements Serializable {

    private String formula;

    private String gender;

    private double weight;

    private double height;

    private int age;

    private double bodyFat;

    private ExerciseLevel exerciseLevel;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(double bodyFat) {
        this.bodyFat = bodyFat;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public ExerciseLevel getExerciseLevel() {
        return exerciseLevel;
    }

    public void setExerciseLevel(ExerciseLevel exerciseLevel) {
        this.exerciseLevel = exerciseLevel;
    }
}
