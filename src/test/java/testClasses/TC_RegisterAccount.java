package testClasses;


import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.AccountsOverviewPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.RegisterPageObjects;
import pageObjects.RegistrationSuccess;
import utilities.ExcelUtils;

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


        rpo.enterDetails("Swati", "Banerjee", "Salt Lake", "Kolkata", "West Bengal", "700097", "5670981234", "45678901", "swati", "Test@123", "Test@123");

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

        rspo.clickaccountOverView();
        AccountsOverviewPageObjects aspo=new AccountsOverviewPageObjects(driver);
        System.out.println("the list of accounts for this customers and it details are:");

        List<String> accountNumbers=aspo.getListOfAccounts();
        List<String> accountBalances=aspo.getListOfBalanceinAccounts();
        List<String> accountAvailableBalance=aspo.getListOfAvailableBalanceinAccounts();
        
        /* 
        for(String acc:accountNumbers)
        {
            System.out.println(acc);
        }
        */
        
        // Iterate over the lists and print account details in one row
        for (int i = 0; i < accountNumbers.size(); i++) {
            System.out.println(accountNumbers.get(i) + " | " 
                               + accountBalances.get(i) + " | " 
                               + accountAvailableBalance.get(i));
        }
        // After retrieving account details
        ExcelUtils.writeAccountDataToExcel("UserAccountCreated", accountNumbers, accountBalances, accountAvailableBalance);

        

        String totalAmount=aspo.getTotalAmount();
        System.out.println("The total amount for the customer account is:"+totalAmount);
        
    }
    

}
