package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.AccountsOverviewPageObjects;
import pageObjects.HomePageObjects;


public class TC_Login_Home_Page extends BaseClass
{
    @Test
    public void login()
    {
        HomePageObjects hpo=new HomePageObjects(driver);
        hpo.enterCredentials("eka", "Test@123");
        hpo.clickLogin();

        AccountsOverviewPageObjects aop=new AccountsOverviewPageObjects(driver);
        String actualText=aop.checkWelcomeMsg();
        String fullMsg=aop.getFullMessage();
        System.out.println(fullMsg);
        if(actualText.equalsIgnoreCase("Welcome"))
        {
            System.out.println("Login Successfull");
        }
        else
        {
            Assert.fail("Login Unsuccessful. Test Case Failed");
        }
    
    }

}
