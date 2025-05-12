package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObjects 
{
    WebDriver driver;

    public RegisterPageObjects(WebDriver driver)
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
    @FindBy(xpath="//input[@id='customer.ssn']") WebElement ssn;
    @FindBy(xpath="//input[@id='customer.username']") WebElement username;
    @FindBy(xpath="//input[@id='customer.password']") WebElement password;
    @FindBy(xpath="//input[@id='repeatedPassword']") WebElement confirmPassword;
    @FindBy(xpath="//input[@value='Register']") WebElement registerBtn;


    //error messages
    @FindBy(xpath="//span[@id='repeatedPassword.errors']") WebElement confirmPwdError;
    

    public void enterDetails(String fn, String ln, String add, String c, String s, String zip, String ph, String sn, String un, String pwd, String cpwd) 
    {
        firstName.sendKeys(fn);
        lastName.sendKeys(ln);
        address.sendKeys(add);
        city.sendKeys(c);
        state.sendKeys(s);
        zipCode.sendKeys(zip);
        phoneNumber.sendKeys(ph);
        ssn.sendKeys(sn);
        username.sendKeys(un);
        password.sendKeys(pwd);
        confirmPassword.sendKeys(cpwd);
    }

    public void clickRegisterBtn()
    {
        registerBtn.click();
    }

    

}
