package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccountSuccess 
{
    WebDriver driver;

    public OpenNewAccountSuccess(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//h1[normalize-space()='Account Opened!']") WebElement accSuccessMsg;
    @FindBy(xpath="//p[normalize-space()='Congratulations, your account is now open.']") WebElement accSuccessMsgFull;
    @FindBy(xpath="//b[normalize-space()='Your new account number:']") WebElement txt1;
    @FindBy(xpath="//a[@id='newAccountId']") WebElement newAccID;

    



}
