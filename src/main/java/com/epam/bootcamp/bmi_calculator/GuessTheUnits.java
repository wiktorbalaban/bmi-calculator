package com.epam.bootcamp.bmi_calculator;

public class GuessTheUnits{

	private double height;
	private double weight;	
	private String unitType;
	
	private static final double ouncesToPounds = 0.0625;
	private static final double centimeterToMeter = 100;
	private static final double feetToInch = 12;
	
	public GuessTheUnits(String height, String weight) throws Exception{
		letterChecker(height, weight);
		guessUnit();
	}
	
	private void letterChecker(String height, String weight) throws Exception{
		for(char c : height.toCharArray()){ // megnézzük, hogy a magasság tartalmaz-e betűt
			if(!(Character.isDigit(c) || c == '.' || c == ',')){
				throw new Exception("Height is contains letters or other characters");
			}
		}
		for(char c : weight.toCharArray()){ // megnézzük, hogy a súly tartalmaz-e betűt
			if(!(Character.isDigit(c) || c == '.' || c == ',')){
				throw new Exception("Weight is contains letters or other characters");
			}
		}
		if(height.contains(",")){ // amennyiben a magasság vesszőt tartalmaz, módosítjuk tizedespontra
			height.replace(",", ".");
		}
		
		if(weight.contains(",")){ // amennyiben a súly vesszőt tartalmaz, módosítjuk tizedespontra
			weight.replace(",", ".");
		}
		
		this.height = Double.parseDouble(height); // átalakítjuk double típusra a magasságot
		this.weight = Double.parseDouble(weight); // átalakítjuk double típusra a súlyt
	}
	
	private void guessUnit(){ // kitaláljuk a mértékegységet
		if(this.height < 100){
			if(this.height < 10 && this.height > 3){ // feet
				convertUnit("feet"); //átkonvertáljuk inch-é
				this.unitType = "US";
			}else if(this.height >= 10){ // inch
				this.unitType = "US";
			}else{ // meter
				this.unitType = "metric";
			}
		}else{ // centimeter
			convertUnit("centimeter"); //átkonvertáljuk méterre
			this.unitType = "metric";
		}
		
		if(this.unitType.equals("US")){ // ounces
			if(this.weight > 1000){
				convertUnit("ounces"); //átkonvertáljuk fontra
			}
		}		
	}
	
	private void convertUnit(String unit){
		if(unit.equals("ounces")){
			this.weight = this.weight / ouncesToPounds;
		}
		if(unit.equals("feet")){
			this.height = this.height * feetToInch;
		}
		if(unit.equals("centimeter")){
			this.height = this.height / centimeterToMeter;
		}
	}
	
	public double getHeight(){
		return this.height;
	}
	
	public double getWeight(){
		return this.weight;
	}
	
	public String getUnitType(){
		return this.unitType;
	}
}
