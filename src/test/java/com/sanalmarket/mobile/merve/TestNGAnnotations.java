package com.sanalmarket.mobile.merve;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	
	@BeforeMethod
	public void bm()
	{
		System.out.println("3");
	}
	
	@BeforeTest
	public void bt()
	{
		System.out.println("1");
		
	}
	
	@BeforeClass
	public void bc()
	{
		System.out.println("2");
	}
	
	
	@Test
	public void main()
	{
		System.out.println("Test");
	}
	
	

}
