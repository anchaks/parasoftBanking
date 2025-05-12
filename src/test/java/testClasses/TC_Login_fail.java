package testClasses;

import java.io.IOException;

import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.HomePageObjects;

public class TC_Login_fail extends BaseClass
{
    @Test
    public void login() throws IOException
    {
        HomePageObjects hpo=new HomePageObjects(driver);
        hpo.enterCredentials("ani", "Test@123");
        //Take screenshot before login
       
       // TakeScreenshot.takeScreenshot(driver, "Before_Login_051102025_11:34PM.png");
        BaseClass.captureScreen("Before Login");
        
        hpo.clickLogin();

        String errorMsg=hpo.getLoginErrorText();
        System.out.println(errorMsg);
        //Take screesnhot after error
       //TakeScreenshot.takeScreenshot(driver, "After_Login_051102025_11:34PM.png");
       BaseClass.captureScreen("After Login");
        String expMsg="The username and password could not be verified.";

        if(errorMsg.equalsIgnoreCase(expMsg))
        {
            System.out.println("Test Case passed as login error is visible");
        }
    }

}
