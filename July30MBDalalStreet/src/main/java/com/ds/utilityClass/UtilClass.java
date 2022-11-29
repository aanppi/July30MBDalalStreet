package com.ds.utilityClass;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.ds.testBase.TestBase;

public class UtilClass extends TestBase{
	
public 	UtilClass()
	{
		PageFactory.initElements(driver, this);
	}
//-----Screenshot----------

    public static void takeScreenshot(String filename) 
    {
    	try
    	{
    	String path="C:\\Users\\user\\eclipse-workspace\\30JulyMBDalalstreet\\Screenshot\\";
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	
    	File desc=new File(path+filename+".png");
    	
    	
			FileHandler.copy(source, desc);
		} 
    	catch (IOException e) 
    	{
			System.out.println("IO Exception - fie not found");
			e.printStackTrace();
		}
    	}
    	
   
    }


