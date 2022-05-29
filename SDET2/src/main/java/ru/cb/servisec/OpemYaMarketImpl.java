package ru.cb.servisec;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.cb.interfaces.OpemYaMarket;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OpemYaMarketImpl implements OpemYaMarket {

    @Override
    public WebDriver openYandex(WebDriver driver) throws InterruptedException {
        driver.manage().window().maximize();

        driver.get("https://yandex.ru/");

        Thread.sleep(2000);

        driver.findElement(By.xpath("//body")).sendKeys(Keys.ESCAPE);

        return driver;

    }

    @Override
    public WebDriver openMarket(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("Маркет")).click();

        Thread.sleep(5000);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

        if(tabs2.size()>1) {

            driver.switchTo().window(tabs2.get(0));
            driver.close();
            driver.switchTo().window(tabs2.get(1));
        }
        driver.findElement(By.linkText("Аптека")).click();
        driver.findElement(By.linkText("Оптика")).click();
        driver.findElement(By.linkText("Футляры")).click();

        return driver;
    }

    @Override
    public WebDriver serFilter(WebDriver driver) throws InterruptedException {

        driver.findElement(By.linkText("Все фильтры")).click();

        driver.findElement(By
                .xpath("/html/body/div[3]/section/div[2]/div/div/div[2]/div[1]/div[1]/div/div/div/div[1]/input"))
                .sendKeys("950");
        driver.findElement(By
                .xpath("/html/body/div[3]/section/div[2]/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]/input"))
                .sendKeys("1500");


        driver.findElement(By.xpath("//span[text() = 'Показать ещё']/..")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[text() = 'MAD WAVE']/..")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[3]/section/div[2]/div/div/div[3]/div/div/a[2]")).click();

        return driver;
    }

    @Override
    public List<String> compText(WebDriver driver) throws InterruptedException {


        Thread.sleep(1000);
        WebElement results= driver
                .findElement(By
                        .xpath("//div[@aria-label = 'Результаты поиска']/div/div/div/div/div/div/div/div[2]//article/div[5]/h3"));

        String text1=results.getText();

        Thread.sleep(1000);

        String temp="\""+text1+"\"";

        driver.findElement(By.id("header-search")).sendKeys(temp);

        driver.findElement(By.xpath("//span[text() = 'Найти']/..")).click();
        Thread.sleep(1000);

        WebElement results2= driver.findElement(By
                .xpath("//div[@aria-label = 'Результаты поиска']"));
        String text2=results2.getText().split("\n")[2];
       // Assert.assertEquals(text1, text2);
        List<String> lists = new ArrayList<String>();
        lists.add(text1);
        lists.add(text2);
        return lists;
    }
}
