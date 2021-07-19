package tests;

import baseClasses.TestBase;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test1 extends TestBase {



    @Test
    public void method1() {
        driver.get().findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[3]/a")).click();
        Thread.currentThread().setPriority(1);
        System.out.println(Thread.currentThread().getId());
        logger.log(Status.PASS, "Passing method");
        long id = Thread.currentThread().getId();
        logger.log(Status.INFO, "id is: " + Long.valueOf(id));
        logger.log(Status.FAIL, Markup.class.getName().toUpperCase());
        Assert.fail("failing... ");
        log.info("HI I am logger");


    }

    @Test(groups = {"exclude"})
    public void method2() {
        driver.get().findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[3]/a")).click();
        Thread.currentThread().setPriority(1);
        long id = Thread.currentThread().getId();
        logger.log(Status.INFO, "id is: " + Long.valueOf(id));
        logger.log(Status.PASS, "Passing method");

    }

    @Test
    public void method3() {
        driver.get().findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[3]/a")).click();
        Thread.currentThread().setPriority(1);
        System.out.println(Thread.currentThread().getId());
        long id = Thread.currentThread().getId();
        logger.log(Status.INFO, "id is: " + Long.valueOf(id));

    }

    @Test
    public void method4() {
        driver.get().findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[3]/a")).click();
        Thread.currentThread().setPriority(1);
        System.out.println(Thread.currentThread().getId());
        long id = Thread.currentThread().getId();
        logger.log(Status.INFO, "id is: " + Long.valueOf(id));

    }

    @Test
    public void method5() {
        driver.get().findElement(By.xpath("//*[@id=\"navbar-brand-centered\"]/ul[2]/li[3]/a")).click();
        Thread.currentThread().setPriority(1);
        System.out.println(Thread.currentThread().getId());
        long id = Thread.currentThread().getId();
        logger.log(Status.INFO, "id is: " + Long.valueOf(id));

    }
}
