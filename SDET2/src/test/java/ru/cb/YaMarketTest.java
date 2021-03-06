package ru.cb;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.cb.interfaces.ExecOpenYa;
import ru.cb.servisec.ExecOpenYaImpl;

import java.util.List;


public class YaMarketTest {

    WebDriver driver;


    ExecOpenYa execOpenYa;

    @Before
    public void iniElem() {
        execOpenYa = new ExecOpenYaImpl();
    }

    //тест для Edge
    @Test
    public void iniEdgeDriver() throws InterruptedException {

      System.setProperty("webdriver.edge.driver", "drivers/edgedriver_win32/msedgedriver.exe");

      driver = new EdgeDriver();

      firstTest(execOpenYa.getTwoText(driver));
    }

    //тест для Firefox
    @Test
    public void iniFirefoxOptions() throws InterruptedException {

      System.setProperty("webdriver.gecko.driver", "drivers/geckodriver/geckodriver.exe");

      driver = new FirefoxDriver();

        firstTest(execOpenYa.getTwoText(driver));
   }

   private void firstTest(List<String> list)
   {
       Assert.assertEquals(list.get(0), list.get(1));
   }

    @After
    public void closeBrow() {
     driver.quit();
    }
}
