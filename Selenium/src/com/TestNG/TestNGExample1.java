package com.TestNG;

import org.testng.annotations.Test;

public class TestNGExample1 {
@Test(priority=1)
public void gmailapplicationlaunch()
{
System.out.println("Gmail Application Launch Successful");	
}
@Test(priority=2)
public void gmailInboxTest() 
{
System.out.println("Inbox Functionality Test Successful");	
}

@Test(enabled=false)
public void gmailComposedMailTest()
{
System.out.println("Composed Functionality Test Successful");	
}
@Test(priority=4)
public void gmailSentMailTest()
{
System.out.println("SentMail Functionality Test Successful");	
}
}






