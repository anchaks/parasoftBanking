package testClasses;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.BaseClass;
import pageObjects.AccountsOverviewPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.OpenNewAccount;
import utilities.ExcelUtils;

public class TC_OpenNewAccount extends BaseClass
{
    /*/
    @Test
    public void openNewAccount()
    {
        //Step 1: Login to the application
        HomePageObjects hpo=new HomePageObjects(driver);
        hpo.enterCredentials("swati", "Test@123");
        hpo.clickLogin();

        // Step 2: Read an existing account number from the Excel sheet
        String excelFilePath = System.getProperty("/Users/arnab/Desktop/Programming_Projects/VSCodeProjects/parabanking_project/RegisterAccountCreated_20250518_191930.xlsx");

        List<String> accountNumbers = ExcelUtils.readFirstAccountNumber(excelFilePath);
        if (accountNumbers.isEmpty()) {
            System.out.println("No account numbers found in Excel.");
            return;
        }

        AccountsOverviewPageObjects apo=new AccountsOverviewPageObjects(driver);
        apo.clickNewAccountLnk();
        OpenNewAccount opo=new OpenNewAccount(driver);
        opo.selectTypeOfAccount("SAVINGS");
        opo.listAllAccounts();
        


    }
    */
     @Test
    public void openNewAccount()
    {
        // Step 1: Login to the application
        HomePageObjects hpo = new HomePageObjects(driver);
        hpo.enterCredentials("swati", "Test@123");
        hpo.clickLogin();

        // Step 2: Read existing account numbers from the Excel sheet
        //String excelFilePath = System.getProperty("user.dir") + "/test-output/excel/UserAccountCreated.xlsx";
        String excelFilePath =  "D:\\VSCodeProjects\\parasoftBanking\\parasoftBanking\\generatedexcelsheets\\UserAccountCreated_.xlsx";
        //String excelFilePath =  "D:\VSCodeProjects\parasoftBanking\parasoftBanking\generatedexcelsheets\UpdatedUserAccountDetails_.xlsx";
        List<String> accountNumbers = ExcelUtils.readAccountNumbersFromExcel(excelFilePath);
        

        if (accountNumbers.isEmpty()) {
            Assert.fail("No account numbers found in the Excel sheet.");
        }

        /* 
        // Define the specific account number to use
        String acc_No = "16674";
        // Check if the specific account number exists in Excel
        if (!accountNumbers.contains(acc_No)) 
        {
            Assert.fail("Specified account number (" + acc_No + ") not found in the Excel sheet.");
        }
        
        */

        // Step 3: Navigate to Open New Account page
        AccountsOverviewPageObjects apo = new AccountsOverviewPageObjects(driver);
        apo.clickNewAccountLnk();

        OpenNewAccount opo = new OpenNewAccount(driver);
        opo.selectTypeOfAccount("SAVINGS");

        // Step 4: Match Excel account numbers with dropdown options or check if entered account number exists in the dropdown
        
        List<String> dropdownAccounts = opo.listAllAccounts();
        
        /* 
        if (!dropdownAccounts.contains(acc_No)) 
        {
            Assert.fail("Specified account number (" + acc_No + ") not found in dropdown options.");
        }
        */

        String selectedAccount = null;

        for (String acc : accountNumbers) {
            if (dropdownAccounts.contains(acc)) {
                selectedAccount = acc;
                break;
            }
        }

        if (selectedAccount == null) {
            Assert.fail("No matching account number found in dropdown.");
        }

        /* 
        // If both checks passed, proceed to select the account and open a new one
        opo.selectAccount(acc_No);
        */

        opo.selectAccount(selectedAccount);
        opo.clickOpenNewAccountBtn();

        // Step 5: Confirm success and log new account
        String successMsg = opo.getSuccessMsg();
        System.out.println("Account open success message: " + successMsg);

        String newAccountId = opo.getNewAccountID();
        System.out.println("New Account ID: " + newAccountId);

        // Step 6: Navigate to Accounts Overview and write updated data to Excel
        opo.clickaccountOverView();

        List<String> updatedAccountNumbers = apo.getListOfAccounts();
        List<String> updatedAccountBalances = apo.getListOfBalanceinAccounts();
        List<String> updatedAvailableBalances = apo.getListOfAvailableBalanceinAccounts();

        ExcelUtils.writeAccountDataToExcel("UpdatedUserAccountDetails", updatedAccountNumbers, updatedAccountBalances, updatedAvailableBalances);
    }
    

}
