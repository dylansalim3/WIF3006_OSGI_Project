package com.fitness.calorie;

import com.fitness.base.ExerciseLevel;

public interface CalorieInterface {
    CalorieResultDto calculateCalorieLevel(CalorieInputDto calorieInputDto);

    ExerciseLevel[] getExerciseLevels();

    String[] getCalorieFormulaList();
}
