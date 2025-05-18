package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationSuccess 
{
    WebDriver driver;

    public RegistrationSuccess(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//p[contains(text(),'Your account was created successfully. You are now')]") WebElement successMsg;

    public String checkRegistrationSuccessMessage()
    {
        String text=successMsg.getText();
        return text;
    }

    @FindBy(xpath="//a[normalize-space()='Accounts Overview']") WebElement accOverViewLnk;

     public void clickaccountOverView()
     {
        accOverViewLnk.click();
     }

}
