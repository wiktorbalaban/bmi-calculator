package com.epam.bootcamp.bmi_calculator;

public class GuessTheUnits{

	private double height;
	private double weight;	
	private String unitType;
	
	
	/**
	 * Váltószám konstansok
	 */
	private static final double ouncesToPounds = 0.0625;
	private static final double centimeterToMeter = 100;
	private static final double feetToInch = 12;
	
	public GuessTheUnits(double height, double weight) throws Exception{
		this.height = height;
		this.weight = weight;
		guessUnit();
	}
	
	/**
	 * A mértékegység megállapító metódus.
	 * Ha a magasság kisebb száznál, és azon belül 10 és 3 között van, akkor feetben kaptuk a magasságot.
	 * Ha a magasság kisebb száznál, de nagyobb vagy egyenlő 10-el, akkor inchben.
	 * Ha a magasság kisebb vagy egyenlő 3-al, akkor méterben.
	 * Ha a magasság nagyobb száznál, akkor pedig centiméterben.
	 * 
	 * A magasság alapján meg tudjuk mondani, hogy milyen mértékegységben kaphattuk a súlyt.
	 * Ha US mértékegységet használunk és a súly nagyobb mint ezer, akkor ounces-ban kaptuk meg a súlyt.
	 * Ha metrikus mértékegységet használunk, és a súly nagyobb mint ezer, valószínűleg két különböző mértékegységben
	 * kaptuk meg a magasságot és a súlyt, ezért hibát dob.
	 * 
	 * Ha feetben, centiméterben vagy ounces-ban kaptuk valamelyik értéket, a convertUnit metódussal át kell alakítanunk azt.
	 * @throws Exception
	 */
	private void guessUnit() throws Exception{ // kitaláljuk a mértékegységet
		if(this.height < 100){
			if(this.height < 10 && this.height > 3){ // feet
				convertUnit("feet"); //átkonvertáljuk inch-re
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
		}else{
			if(this.weight > 1000){
				throw new Exception("Height and weight is in different metric.");
			}
		}
	}
	
	
	/**
	 * Átváltja a mértékegységeket egységesre.
	 * @param unit
	 */
	private void convertUnit(String unit){
		if(unit.equals("ounces")){
			this.weight = this.weight * ouncesToPounds;
		}
		if(unit.equals("feet")){
			this.height = this.height * feetToInch;
		}
		if(unit.equals("centimeter")){
			this.height = this.height / centimeterToMeter;
		}
	}
	
	/**
	 * Súly getter
	 * @return a súly
	 */
	public double getWeight(){
		return this.weight;
	}
	
	/**
	 * Magasság getter
	 * @return magasság
	 */
	public double getHeight(){
		return this.height;
	}
	
	/**
	 * A mértékegység típusa getter
	 * @return mértékegység típusa
	 */
	public String getUnitType(){
		return this.unitType;
	}
}
