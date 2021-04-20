package tests;

import jdk.jshell.spi.ExecutionControl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.BrowserUtils;
import utilities.Configuration;
import utilities.TestBase;


public class PizzaQuantityTest extends TestBase {
    @Test
    public void totalPriceTest(){
        driver.get(Configuration.getProperty("PizzaURL"));
        HomePage homePage = new HomePage();
        BrowserUtils.selectDropdownByValue(homePage.selectionPizza,"Small 6 Slices - no toppings");
        BrowserUtils.selectDropdownByValue(homePage.selectionTopping1,"Diced Mango");
        BrowserUtils.selectDropdownByValue(homePage.selectionTopping2,"Diced Mango");
        homePage.quantity.sendKeys(Keys.BACK_SPACE);
        homePage.quantity.sendKeys("2");
        homePage.quantity.sendKeys(Keys.ENTER);
        String expectedPrice="13.5";
        homePage.cost.isSelected();
        String actualPrice=homePage.cost.getAttribute("value");
        Assert.assertEquals(actualPrice,expectedPrice,"Actual Price " +actualPrice+" it should match this price "+expectedPrice);









    }


}
