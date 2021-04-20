package test;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.TestBase;

public class TC03 extends TestBase {

    //will check Reset button

    @Test
    public void tc03() {
        String pizzaQuantity = "2";
        HomePage homePage = new HomePage();

        driver.get(Configuration.getProperty("PizzaURL"));
        BrowserUtils.selectDropdownByValue(homePage.selectionPizza, "Small 6 Slices - no toppings");
        BrowserUtils.selectDropdownByValue(homePage.selectionTopping1, "Diced Mango");
        BrowserUtils.selectDropdownByValue(homePage.selectionTopping2, "Diced Mango");
        homePage.quantity.sendKeys(Keys.BACK_SPACE);
        homePage.quantity.sendKeys(pizzaQuantity);
        Assert.assertEquals(homePage.quantity.getAttribute("value"), pizzaQuantity);
        homePage.resetButton.click();
        String expectedQuantity = "0";
        String actualQuantity = homePage.quantity.getAttribute("value");
        Assert.assertEquals(actualQuantity, expectedQuantity);

    }
}
