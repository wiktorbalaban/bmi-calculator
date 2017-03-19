package com.epam.bootcamp.bmi_calculator.interfaces;

/**
 * Metrikus vagy US mértékegység interface
 * @author bencekiraly
 *
 */
public interface UnitsInterface{
	
	double getBMI();
	
	/**
	 * Itt számoljuk ki a testtömegindexet.
	 */
	void setBMI(double weight, double height);
	
}
