package testClasses;

import java.util.List;

import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.AccountsOverviewPageObjects;
import pageObjects.HomePageObjects;


public class TC_AccountsOverView extends BaseClass
{
    @Test
    public void accountOverview() throws InterruptedException
    {
        HomePageObjects hpo=new HomePageObjects(driver);
        hpo.enterCredentials("eka", "Test@123");
        hpo.clickLogin();

        //After logging in , we land in Account Overview page and we list the account numbers
        Thread.sleep(5000);
        AccountsOverviewPageObjects aop=new AccountsOverviewPageObjects(driver);
        System.out.println("the list of accounts for this customers and it details are:");

        List<String> accountNumbers=aop.getListOfAccounts();
        List<String> accountBalances=aop.getListOfBalanceinAccounts();
        List<String> accountAvailableBalance=aop.getListOfAvailableBalanceinAccounts();
        
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
        
        

        String totalAmount=aop.getTotalAmount();
        System.out.println("The total amount for the customer account is:"+totalAmount);
        
    }

    

}
