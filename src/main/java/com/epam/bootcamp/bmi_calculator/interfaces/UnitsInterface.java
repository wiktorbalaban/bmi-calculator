package com.epam.bootcamp.bmi_calculator.interfaces;

public interface UnitsInterface{
	
	double getBMI();
	
	void setBMI(double weight, double height) throws Exception;
	
}
