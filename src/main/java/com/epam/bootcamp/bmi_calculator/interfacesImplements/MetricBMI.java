package com.epam.bootcamp.bmi_calculator.interfacesImplements;

import com.epam.bootcamp.bmi_calculator.interfaces.UnitsInterface;

public class MetricBMI implements UnitsInterface{
	
	private double bmi;
	
	public double getBMI(){
		return this.bmi;
	}
	
	public void setBMI(double weight, double height){
		this.bmi = weight/(height*height); //számolja a metrikus BMI-t
	}
	
}
