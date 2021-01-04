package com.fitness.web;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.fitness.bmi.BmiInterface;
import com.fitness.calorie.CalorieInterface;
import com.fitness.idealweight.IdealWeightInterface;

@Component
public class Activator {
	
	@Reference
	public void setCalorieImpl(CalorieInterface calorieImpl) {
		Assessment.calorieImpl = calorieImpl;
	}
	
	public void unsetCalorieImpl(CalorieInterface calorieImpl) {
		Assessment.calorieImpl = null;
	}
	
	@Reference
	public void setBmiImpl(BmiInterface bmiImpl) {
		Assessment.bmiImpl = bmiImpl;
	}
	
	public void unsetBmiImpl(BmiInterface bmiImpl) {
		Assessment.bmiImpl = null;
	}
	
	@Reference
	public void setIdealWeightImpl(IdealWeightInterface idealWeightImpl) {
		Assessment.idealWeightImpl = idealWeightImpl;
	}
	
	public void unsetIdealWeightImpl(IdealWeightInterface idealWeightImpl) {
		Assessment.idealWeightImpl = null;
	}
	
	@Activate
	public void activate() {
		System.out.println("com.fitness.web activated");
	}
}
