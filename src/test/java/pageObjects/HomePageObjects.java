package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects 
{
    WebDriver driver;

    public HomePageObjects(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//input[@name='username']") WebElement userName;
    @FindBy(xpath="//input[@name='password']") WebElement password;
    @FindBy(xpath="//input[@value='Log In']") WebElement loginBtn;
    @FindBy(xpath="//a[normalize-space()='Forgot login info?']") WebElement forgotLoginInfo;
    @FindBy(xpath="//a[normalize-space()='Register']") WebElement registerAccount;

    //login error message
    @FindBy(xpath="//p[@class='error']") WebElement errorMsg;

    public void clickRegister()
    {
        registerAccount.click();
    }

    public void enterCredentials(String user, String pwd)
    {
        userName.sendKeys(user);
        password.sendKeys(pwd);
    }

    public void clickLogin()
    {
        loginBtn.click();
    }

    public void clickForgotLogin()
    {
        forgotLoginInfo.click();

    }

    public String getLoginErrorText()
    {
        String err=errorMsg.getText();
        return err;
    }
}
