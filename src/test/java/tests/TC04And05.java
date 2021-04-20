package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.TestBase;

public class TC04And05 extends TestBase {

    @DataProvider(name = "testData")
    public Object[][] testData(){
        return new Object[][] {
                {"Small 6 Slices - no toppings $6.75", "Diced Mango", "2", "John Doe", "1234679", By.id("ccpayment"), "Thank you for your order!"},
                {"Small 6 Slices - no toppings $6.75", "Diced Mango", "2", "John Doe", "1234679", By.id("cashpayment"), "Thank you for your order!"}
        };
    }

    @Test (dataProvider = "testData")
    public void tc04And05(String pizzaType, String toppings, String quantity, String name,
                          String phone, By paymentType, String expectedMessage){
        driver.get(Configuration.getProperty("URL"));
        HomePage homePage = new HomePage();
        BrowserUtils.selectDropdownByVisibleText(homePage.selectionPizza,pizzaType);
        BrowserUtils.selectDropdownByVisibleText(homePage.selectionTopping1, toppings);
        homePage.quantity.sendKeys(quantity);
        homePage.name.sendKeys(name);
        homePage.phone.sendKeys(phone);
        driver.findElement(paymentType).click();
        homePage.placeOrderButton.click();
        String actualMessage = homePage.successMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
