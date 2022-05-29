package ru.cb.servisec;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cb.interfaces.ExecOpenYa;
import ru.cb.interfaces.OpemYaMarket;

import java.util.List;

@Service
public class ExecOpenYaImpl implements ExecOpenYa {


    private OpemYaMarket opemYaMarket;

    public ExecOpenYaImpl() {
        opemYaMarket = new OpemYaMarketImpl();
    }

    @Override
    public List<String> getTwoText(WebDriver driver) throws InterruptedException {
        driver=opemYaMarket.openYandex(driver);
        driver=opemYaMarket.openMarket(driver);
        driver=opemYaMarket.serFilter(driver);
        return opemYaMarket.compText(driver);
    }
}
