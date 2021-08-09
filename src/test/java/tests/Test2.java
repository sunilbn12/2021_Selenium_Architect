package tests;

import baseClasses.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test2 extends TestBase {

    @Test
    public void m1() {

        driver.get().get("https://www.trustbasket.com/");
        driver.get().manage().window().fullscreen();
        driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);



        Actions actions = new Actions(driver.get());
        WebElement men = driver.get().findElement(By.xpath("(//span[contains(text(),'Pots')])[1]"));
        actions.moveToElement(men).click();
        System.out.println(men.getAttribute("text"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        } finally {

        }

    }
}
