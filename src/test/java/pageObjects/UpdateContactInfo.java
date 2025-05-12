package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactInfo 
{
    WebDriver driver;

    public UpdateContactInfo(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//input[@id='customer.firstName']") WebElement firstName;
    @FindBy(xpath="//input[@id='customer.lastName']") WebElement lastName;
    @FindBy(xpath="//input[@id='customer.address.street']") WebElement address;
    @FindBy(xpath="//input[@id='customer.address.city']") WebElement city;
    @FindBy(xpath="//input[@id='customer.address.state']") WebElement state;
    @FindBy(xpath="//input[@id='customer.address.zipCode']") WebElement zipCode;
    @FindBy(xpath="//input[@id='customer.phoneNumber']") WebElement phoneNumber;

    @FindBy(xpath="//input[@value='Update Profile']") WebElement updateProfileBtn;

    //profile updates success message
    @FindBy(xpath="//h1[normalize-space()='Profile Updated']") WebElement profileUpdatedSuccessMsg;
    String text="updated";
    @FindBy(xpath="//p[contains(text(), 'updated')]") WebElement fullUpdateStatusMsg;


    public void clickUpdateProfileBtn()
    {
        updateProfileBtn.click();
    }

    public String getUpdateText()
    {
        String txt=profileUpdatedSuccessMsg.getText();
        return txt;
    }

    public String getUpdateMessage()
    {
        String msg=fullUpdateStatusMsg.getText();
        return msg;
    }

    public void updateFirstName(String fn)
    {
        firstName.clear();
        firstName.sendKeys(fn);
    }

    public void updateLastName(String ln)
    {
        lastName.clear();
        lastName.sendKeys(ln);
    }

    public void updateAddress(String add)
    {
        address.clear();
        address.sendKeys(add);
    }

    public void updateCity(String c)
    {
        city.clear();
        city.sendKeys(c);
    }

    public void updateState(String s)
    {
        state.clear();
        state.sendKeys(s);
    }

    public void updateZIPCode(String zip)
    {
        zipCode.clear();
        zipCode.sendKeys(zip);
    }

    public void updatePhoneNumber(String ph)
    {
        phoneNumber.clear();
        phoneNumber.sendKeys(ph);
    }


}
