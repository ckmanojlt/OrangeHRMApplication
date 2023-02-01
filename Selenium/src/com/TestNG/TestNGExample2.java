package com.TestNG;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample2 {
//@BeforeTest...@Test...@AfterTest
	
	@BeforeTest
	public void gmailapplicationlaunch()
	{
		System.out.println("Gmail Application Launch Successfull");
	}
	
	@AfterTest
	public void gmailapplicationclose()
	{
		System.out.println("gmail application closed successfully");
	}
	@Test(priority=1)
	public void gmailInboxTest()
	{
		System.out.println("Inbox functionality test successfull");
	}
	@Test(enabled=false)
	public void gmailComposedMailTest()
	{
		System.out.println("ComposedMail functionality test successful");
	}
	@Test(priority=2)
	public void gmailsentmailtest()
	{
	System.out.println("sentmail functionality test successfull");	
	}
	@Test(priority=3)
	public void gamailDraftsTest()
	{
		System.out.println("Drafts functionality test successfull");
	}
	
	
}
