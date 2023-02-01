package com.Log;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public void takeScreenshot(WebDriver driver,String imageName) throws IOException {
		TakesScreenshot takeSc =(TakesScreenshot)driver;
		File screenshot = takeSc.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("./screenshot/"+imageName+".png"));
	}
}
