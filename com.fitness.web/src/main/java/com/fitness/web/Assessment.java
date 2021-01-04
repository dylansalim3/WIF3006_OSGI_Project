package com.fitness.web;

import com.fitness.base.PersonalInfo;
import com.fitness.bmi.BmiInterface;
import com.fitness.calorie.CalorieInputDto;
import com.fitness.calorie.CalorieInterface;
import com.fitness.calorie.CalorieResultDto;
import com.fitness.idealweight.IdealWeightInterface;

import javax.servlet.http.HttpServletRequest;


public class Assessment {
	
	static CalorieInterface calorieImpl;
	static BmiInterface bmiImpl;
	static IdealWeightInterface idealWeightImpl;
	
	public static void showForm(HttpServletRequest request) {
		if (calorieImpl == null) return;
		
		request.setAttribute("exerciseLevels", calorieImpl.getExerciseLevels());
		request.setAttribute("bmrFormulaList", calorieImpl.getCalorieFormulaList());
	}
	
	public static void submitForm(HttpServletRequest request) {
		if (calorieImpl == null || bmiImpl == null || idealWeightImpl == null) return;
		
		//get personal info from request 
		PersonalInfo personalInfo = new PersonalInfo();
		
		personalInfo.setAge(Integer.parseInt(request.getParameter("age")));
		personalInfo.setHeight(Double.parseDouble(request.getParameter("height")));
		personalInfo.setWeight(Double.parseDouble(request.getParameter("weight")));
		personalInfo.setGender(request.getParameter("gender"));
		personalInfo.setExerciseLevelId(Integer.parseInt(request.getParameter("exerciseLevelId")));
		personalInfo.setCalorieFormula(request.getParameter("calorieFormula"));
		personalInfo.setBodyFat(Double.parseDouble(request.getParameter("bodyFat")));

		System.out.println("Form received");
		System.out.println(personalInfo);
		
        //calculate bmi
        double bmi = bmiImpl.getBMI(personalInfo.getWeight(), personalInfo.getHeight() / 100);
        String bmiCategory = bmiImpl.getCategory(bmi);
        request.setAttribute("bmi", String.format("%.2f",bmi));
        request.setAttribute("bmiCategory", bmiCategory);

        //calculate calorie
        CalorieInputDto calorieInputDto = new CalorieInputDto();
        calorieInputDto.setAge(personalInfo.getAge());
        calorieInputDto.setBodyFat(personalInfo.getBodyFat());
        calorieInputDto.setExerciseLevel(calorieImpl.getExerciseLevels()[personalInfo.getExerciseLevelId()]);
        calorieInputDto.setFormula(personalInfo.getCalorieFormula());
        calorieInputDto.setGender(personalInfo.getGender());
        calorieInputDto.setHeight(personalInfo.getHeight());
        calorieInputDto.setWeight(personalInfo.getWeight());

        CalorieResultDto calorieResultDto = calorieImpl.calculateCalorieLevel(calorieInputDto);
        int caloriesToMaintain = calorieResultDto.getCaloriesToMaintain();
        int caloriesToMildWeightLoss = calorieResultDto.getCaloriesToMildWeightLoss();
        int caloriesToWeightLoss = calorieResultDto.getCaloriesToWeightLoss();
        int caloriesToExtremeWeightLoss = calorieResultDto.getCaloriesToExtremeWeightLoss();
        
        request.setAttribute("caloriesToMaintain", caloriesToMaintain);
        request.setAttribute("caloriesToMildWeightLoss", caloriesToMildWeightLoss);
        request.setAttribute("caloriesToWeightLoss", caloriesToWeightLoss);
        request.setAttribute("caloriesToExtremeWeightLoss", caloriesToExtremeWeightLoss);

        //calculate ideal weight
        double idealWeightValue = idealWeightImpl.calIdealWeight(personalInfo.getHeight()/100, personalInfo.getGender());
        request.setAttribute("idealWeight", String.format("%.2f",idealWeightValue));
    }
}
