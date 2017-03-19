package com.epam.bootcamp.bmi_calculator.interfacesImplements;

import com.epam.bootcamp.bmi_calculator.interfaces.UnitsInterface;

public class UsBMI implements UnitsInterface{
	
	private static final int usMultiplier = 703;
	
	private double bmi;
	
	public double getBMI(){
		return this.bmi;
	}
	
	/**
	 * A US mértékegységnél kell konstans, amilve meg kell szorozni a súlyt. Ezt a szorzót a usMultiplier konstans tartalmazza
	 */
	public void setBMI(double weight, double height){
		this.bmi = usMultiplier*weight/(height*height); // számolja a US bmi-t
	}
	
}
