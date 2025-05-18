package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccount 
{
    WebDriver driver;

    public OpenNewAccount(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
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

     //actual objects and action mthods of the new account page
     //CHECKING and SAVINGS- these are the 2 values
    @FindBy(xpath="//select[@id='type']") WebElement typeOfAccount;

    public void selectTypeOfAccount(String accType)
    {
        Select sel=new Select(typeOfAccount);
        sel.selectByVisibleText(accType);
    }

    @FindBy(xpath="//select[@id='fromAccountId']") WebElement accID;

    //list all accounts in the dropdown
    /*
    public void listAllAccounts(){
      Select drop=new Select(accID);
      List<WebElement> options=drop.getOptions();
      System.out.println("List of Accounts:");
      
      for(WebElement option:options)
      {
         System.out.println(option.getText());
      }
      
    }
      */
     public List<String> listAllAccounts() 
     {
      Select drop = new Select(accID);
      List<WebElement> options = drop.getOptions();
      List<String> accountList = new ArrayList<>();

      for (WebElement option : options)
       {
          String text = option.getText().trim();
          System.out.println(text);
          accountList.add(text);
       }

    return accountList;
}
 

    public void selectAccount(String accNo)
    {
        Select sel=new Select(accID);
        sel.selectByVisibleText(accNo);
    }

    @FindBy(xpath="//input[@value='Open New Account']") WebElement openNewAccountBtn;

    public void clickOpenNewAccountBtn()
    {
        openNewAccountBtn.click();
    }

    @FindBy(xpath="//p[contains(translate(normalize-space(), 'CONGRATULATIONS', 'congratulations'), 'congratulations')]") WebElement accountOpenMsg;

    public String getSuccessMsg()
    {
      String txt=accountOpenMsg.getText();
      return txt;
    }

    //new account ID after opening an account
    @FindBy(xpath="//a[@id='newAccountId']") WebElement newAccId;
    @FindBy(xpath="//b[normalize-space()='Your new account number:']") WebElement msg;

    public String getNewAccountMsg()
    {
      String txt1=msg.getText();
      return txt1;
    }
    public String getNewAccountID()
    {
      String txt2=newAccId.getText();
      return txt2;
    }

    //click on newly created account ID
    public void goToNewAccID()
    {
      newAccId.click();
    }

    
}
