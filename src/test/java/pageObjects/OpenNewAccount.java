package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccount 
{
    WebDriver driver;

    public OpenNewAccount(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@value='Open New Account']") WebElement openNewAccountBtn;

    public void clickOpenNewAccountBtn()
    {
        openNewAccountBtn.click();
    }

    
}
