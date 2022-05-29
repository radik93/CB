package ru.cb.interfaces;

import org.openqa.selenium.WebDriver;

import java.util.List;
/*
 * Интерфейс для получения 2-х названий товара
 * @author radik
 * @version 1.0
 */
public interface ExecOpenYa {
    /*
     * Метод для получения 2-х названий товара принимает WebDriver и
     * вызывате функции для запуска браузера и открытия маркета
     * @return Везвращает массив из 2-х названий товара
     * @author radik
     * @version 1.0
     */
    List<String> getTwoText(WebDriver driver) throws InterruptedException;
}
