package testClasses;

//import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.AccountsOverviewPageObjects;
import pageObjects.HomePageObjects;
//import utilities.ExcelUtils;


public class TC_Login_Home_Page extends BaseClass
{
    @Test
    public void login()
    {
        HomePageObjects hpo=new HomePageObjects(driver);
        hpo.enterCredentials("swati", "Test@123");
        hpo.clickLogin();

        AccountsOverviewPageObjects aspo=new AccountsOverviewPageObjects(driver);
        String actualText=aspo.checkWelcomeMsg();
        String fullMsg=aspo.getFullMessage();
        System.out.println(fullMsg);
        if(actualText.equalsIgnoreCase("Welcome"))
        {
            System.out.println("Login Successfull");
        }
        else
        {
            Assert.fail("Login Unsuccessful. Test Case Failed");
        }
        /*
        System.out.println("the list of accounts for this customers and it details are:");

        List<String> accountNumbers=aspo.getListOfAccounts();
        List<String> accountBalances=aspo.getListOfBalanceinAccounts();
        List<String> accountAvailableBalance=aspo.getListOfAvailableBalanceinAccounts();
        // After retrieving account details
        ExcelUtils.writeAccountDataToExcel("", accountNumbers, accountBalances, accountAvailableBalance);
         */
    
    }

}
