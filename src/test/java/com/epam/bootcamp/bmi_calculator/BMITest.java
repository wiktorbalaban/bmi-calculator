package com.epam.bootcamp.bmi_calculator;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.ExpectedException;

import com.epam.bootcamp.bmi_calculator.interfacesImplements.MetricBMI;

public class BMITest {

	@Test
	public void GuessTheUnitsTest1() throws Exception{
		GuessTheUnits gtu = new GuessTheUnits("1.7","50.0");
		assertEquals(gtu.getUnitType(),"metric");
	}
	
	@Test
	public void GuessTheUnitsTest2() throws Exception{
		GuessTheUnits gtu = new GuessTheUnits("1.7","50.0");
		assertEquals(gtu.getHeight(),1.7,0.1);
		assertEquals(gtu.getWeight(),50,0.1);
	}
	
	@Test
	public void BMITest1() throws Exception{
		App app = new App("50.0","1.7");
		assertEquals(app.calculateBMI(),17.3,1);
	}
	
	@Test
	public void BMITest2() throws Exception{
		try{
			App app = new App("A","1.B");
			app.calculateBMI();
		}catch(Exception e){
			assertEquals(e.getMessage(),"Height is contains letters or other characters");
		}
	}
	
}