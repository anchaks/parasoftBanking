package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverviewPageObjects 
{
    WebDriver driver;

    /*
    The constructor takes the WebDriver instance and assigns it.
    PageFactory.initElements(driver, this) initializes all the @FindBy annotated WebElements in this class. 
    */

    public AccountsOverviewPageObjects(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//b[normalize-space()='Welcome']") WebElement welcmMsg;
    @FindBy(xpath="//p[@class='smallText']") WebElement fullWelcomeMsg;

    public String checkWelcomeMsg()
    {
        String text=welcmMsg.getText();
        return text;
    }

    public String getFullMessage()
    {
        String text=fullWelcomeMsg.getText();
        return text;
    }

    @FindBy(xpath="//b[starts-with(normalize-space(), '$')]") WebElement amount;

    public String getTotalAmount()
    {
        String am=amount.getText();
        return am;
    }

    //Locate the List of Accounts
    /*
    This uses an XPath to locate all first-column <td> elements inside <tbody> of a table, excluding the last row (which contains "Total").
    The List<WebElement> stores all matching <td> cells.
    @FindBy is part of Page Factory and automatically finds elements when the page is loaded. 
    */

    @FindBy(xpath="//tbody/tr[position() < last()]/td[1]") private List<WebElement> accountNumberCells;
    // Method to get the text values of the list of accounts
    public List<String> getListOfAccounts()
    {
        //Creates an empty List<String> to store the account numbers.
        List<String> accountNumbers=new ArrayList<>();

        //Explanation for the loop
        /*Loops through each <td> WebElement in the list.
        Gets the visible text from each cell using .getText(), trims whitespace.
        If the text is not empty, it's added to the accountNumbers list. 
        */
        for(WebElement cell:accountNumberCells)
        {
            String text=cell.getText().trim();
            if(!text.isEmpty())
            {
                accountNumbers.add(text);
            }
        }
        return accountNumbers;
        
    }

    //locate the list of account balances
    @FindBy(xpath="//tbody/tr[position() < last()]/td[2]") private List<WebElement> accountBalanceCells;
    // Method to get the text values of the balance in each account
    public List<String> getListOfBalanceinAccounts()
    {
        //Creates an empty List<String> to store the account number balance.
        List<String> accountBalance=new ArrayList<>();

        //Explanation for the loop
        /*Loops through each <td> WebElement in the list.
        Gets the visible text from each cell using .getText(), trims whitespace.
        If the text is not empty, it's added to the accountNumbers list. 
        */
        for(WebElement cell:accountBalanceCells)
        {
            String text=cell.getText().trim();
            if(!text.isEmpty())
            {
                accountBalance.add(text);
            }
        }
        return accountBalance;
        
    }

    //Locate the list of available amounts
    @FindBy(xpath="//tbody/tr[position() < last()]/td[3]") private List<WebElement> accountAvailableBalanceCells;
    // Method to get the text values of the balance in each account
    public List<String> getListOfAvailableBalanceinAccounts()
    {
        //Creates an empty List<String> to store the account number available balance.
        List<String> accountAvailableBalance=new ArrayList<>();

        //Explanation for the loop
        /*Loops through each <td> WebElement in the list.
        Gets the visible text from each cell using .getText(), trims whitespace.
        If the text is not empty, it's added to the accountNumbers list. 
        */
        for(WebElement cell:accountAvailableBalanceCells)
        {
            String text=cell.getText().trim();
            if(!text.isEmpty())
            {
                accountAvailableBalance.add(text);
            }
        }
        return  accountAvailableBalance;
        
    }

     //Listing account services
     @FindBy(xpath="//a[normalize-space()='Open New Account']") WebElement newAccountLnk;
     public void clickNewAccountLnk()
     {
        newAccountLnk.click();
     }

     @FindBy(xpath="//a[normalize-space()='Accounts Overview']") WebElement accOverViewLnk;

     public void clickaccountOverView()
     {
        accOverViewLnk.click();
     }


     @FindBy(xpath="//a[normalize-space()='Transfer Funds']") WebElement transferFundsLnk;
     public void clickTransferFundsLnk()
     {
        transferFundsLnk.click();
     }

     @FindBy(xpath="//a[normalize-space()='Bill Pay']") WebElement billPayLnk;
     public void clickBillPayLnk()
     {
        billPayLnk.click();
     }

     @FindBy(xpath="//a[normalize-space()='Find Transactions']") WebElement findTranscLnk;
     public void clickFindTransactionLnk()
     {
        findTranscLnk.click();
     }
     
     @FindBy(xpath="//a[normalize-space()='Update Contact Info']") WebElement updateContactLnk;
     public void clickUpDateContactLnk()
     {
        updateContactLnk.click();
     }

     @FindBy(xpath="//a[normalize-space()='Request Loan']") WebElement reqLoanLnk;
     public void clickRequestLoanLnk()
     {
        reqLoanLnk.click();
     }

     @FindBy(xpath="//a[normalize-space()='Log Out']") WebElement logoutLnk;
     public void clickLogoutLnk()
     {
        logoutLnk.click();
     }

     @FindBy(xpath="//h1[normalize-space()='Account Opened!']") WebElement accSuccessMsg;
    @FindBy(xpath="//p[normalize-space()='Congratulations, your account is now open.']") WebElement accSuccessMsgFull;
    @FindBy(xpath="//b[normalize-space()='Your new account number:']") WebElement txt1;
    @FindBy(xpath="//a[@id='newAccountId']") WebElement newAccID;//new opened account

    public String getAccSuccessMsg()
    {
        String t=accSuccessMsg.getText();
        return t;
    }

    public String getAccSuccessMsgFull()
    {
        String t=accSuccessMsgFull.getText();
        return t;
    }

    public String getNewAccountID()
    {
        String t=newAccID.getText();
        return t;
    }



}
