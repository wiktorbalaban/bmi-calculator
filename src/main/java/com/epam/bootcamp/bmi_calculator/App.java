package com.epam.bootcamp.bmi_calculator;

import com.epam.bootcamp.bmi_calculator.interfacesImplements.*;

public class App extends Exception
{

	private String weight;
	private String height;
	
	public App(String weight, String height) throws Exception{
		EmptyChecker(weight, height);
		this.weight = weight;
		this.height = height;
	}
	
	private void EmptyChecker(String weight, String height) throws Exception{ // ez a metódus megnézi, hogy üres-e a súly vagy magasság
		if(weight.isEmpty()){
			throw new Exception("Weight is empty.");
		}
		if(height.isEmpty()){
			throw new Exception("Height is empty.");
		}	
	}
	
	public double calculateBMI() throws Exception{ //végül kiszámoljuk a BMI-t
		GuessTheUnits gtu = new GuessTheUnits(this.height, this.weight);
		if(gtu.getUnitType().equals("US")){
			UsBMI ubmi = new UsBMI();
			ubmi.setBMI(gtu.getWeight(), gtu.getHeight());
			return ubmi.getBMI();
		}else if(gtu.getUnitType().equals("metric")){
			MetricBMI mbmi = new MetricBMI();
			mbmi.setBMI(gtu.getWeight(), gtu.getHeight());
			return mbmi.getBMI();
		}else{
			throw new Exception("Valami elszállt");
		}
	}
	
}
