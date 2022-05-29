package ru.cb.interfaces;

import org.openqa.selenium.WebDriver;

import java.util.List;
/*
 * Интерфейс выполения операций по октрытию нужной страницы и поиска товара
 * @author radik
 * @version 1.0
 */
public interface OpemYaMarket {
    /*
     * Метод ринимает WebDriver и открывает в барузере страницу yandex.ru
     * на весь экран ждет пока загрузиться модальное окно и закрывает его
     * @return Везвращает  WebDriver
     * @author radik
     * @version 1.0
     */
    WebDriver openYandex(WebDriver driver) throws InterruptedException;
    /*
     * Метод ринимает WebDriver и переходит я яндекс маркет в нужный подраздел
     * @return Везвращает  WebDriver
     * @author radik
     * @version 1.0
     */
    WebDriver openMarket(WebDriver driver) throws InterruptedException;
    /*
     * Метод ринимает WebDriver и устанавливает фильтры поиска товара
     * @return Везвращает  WebDriver
     * @author radik
     * @version 1.0
     */
    WebDriver serFilter(WebDriver driver) throws InterruptedException;

    /*
     * Метод ринимает WebDriver ищет название товара 2 способами
     * @return Везвращает  массив из названий товара
     * @author radik
     * @version 1.0
     */
    List<String> compText(WebDriver driver) throws InterruptedException;
}
