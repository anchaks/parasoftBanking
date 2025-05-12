package testClasses;


import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.HomePageObjects;
import pageObjects.RegisterPageObjects;
import pageObjects.RegistrationSuccess;

public class TC_RegisterAccount extends BaseClass
{
    @Test()
    public void regsiterAccount()
    {
        HomePageObjects hpo=new HomePageObjects(driver);
        hpo.clickRegister();
        RegisterPageObjects rpo=new RegisterPageObjects(driver);
       
       /*
        String password, confirmPassword;
         
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter password:");
        password=sc.nextLine();
        System.out.println("Enter confirm password:");
        confirmPassword=sc.nextLine();
        sc.close();
        */


        rpo.enterDetails("Ekaghni", "Dey", "Salt Lake", "Kolkata", "West Bengal", "700097", "5670981234", "45678901", "eka", "Test@123", "Test@123");

        rpo.clickRegisterBtn();

        RegistrationSuccess rspo=new RegistrationSuccess(driver);
        String actualText=rspo.checkRegistrationSuccessMessage();
        System.out.println(actualText);
        String expText="Your account was created successfully. You are now logged in.";
        if(actualText.equalsIgnoreCase(expText))
        {
            System.out.println("Test Case Passed");
        }
        else
        {
            Assert.fail("Test Case Failed");
        }
    }

}
