package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import java.util.List;

public class HomePage {
    public HomePage() {

        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//*[@id='pizza1Pizza']")
    public WebElement selectionPizza;

    @FindBy(xpath = "//*[@class='toppings1']")
    public WebElement selectionTopping1;

    @FindBy(xpath = "//*[@class='toppings2']")
    public WebElement selectionTopping2;

    @FindBy(id = "pizza1Qty")
    public WebElement quantity;

    @FindBy(id = "pizza1Cost")
    public WebElement cost;

    @FindBy(id = "name")
    public WebElement name;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id = "phone")
    public WebElement phone;

    @FindBy(id = "ccpayment")
    public WebElement creditCardPayment;

    @FindBy(id = "cashpayment")
    public WebElement cashPayment;

    @FindBy(id = "placeOrder")
    public WebElement placeOrderButton;

    @FindBy(id = "reset")
    public WebElement resetButton;

}
