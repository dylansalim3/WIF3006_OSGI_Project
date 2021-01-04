package com.fitness.idealweightimpl;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

import com.fitness.idealweight.IdealWeightInterface;

@Component
public class IdealWeightImpl implements IdealWeightInterface {
	private static final String MALE = "male";
    private static final String FEMALE = "female";

    public double calIdealWeight(double height, String gender) {
        double counter = 0;
        if (gender.equalsIgnoreCase(MALE)) {
            counter = 21.5;
        } else if (gender.equalsIgnoreCase(FEMALE)) {
            counter = 23;
        }
        return Math.pow(height,2) * counter;
    }
    
    @Activate
    public void activate() {
    	System.out.println("com.fitness.idealweight activated");
    }
}
