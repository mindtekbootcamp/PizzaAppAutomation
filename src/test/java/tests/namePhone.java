package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.Driver;
import utilities.TestBase;

public class namePhone extends TestBase {

    @Test
    public void namePhoneTest(){

        driver.get(Configuration.getProperty("PizzaURL"));
        //driver.get("file:///Users/anneconklelap/IdeaProjects/PizzaAppAutomation/index.html");
        HomePage homePage = new HomePage();
        homePage.selectionPizza.click();
        BrowserUtils.selectDropdownByValue(homePage.selectionPizza, "Small 6 Slices - no toppings $6.75");
        BrowserUtils.selectDropdownByValue(homePage.selectionTopping1, "Diced Mango");
        homePage.quantity.sendKeys("2");
        homePage.placeOrderButton.click();


    }

}
