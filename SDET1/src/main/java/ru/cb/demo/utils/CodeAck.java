package ru.cb.demo.utils;

public class CodeAck {

    private static final String[] discСode  = {"Ошибка провеки",
            "Доставлено",
            "Не доставлено",
            "Проверка суммы",
            "Проверка реквизитов",
            "",
            "",
            "",
            "Без запроса 1",
            "",
            "",
            "",
            "Без запроса 2"};

    public static int getCode(String disc) {
        for (int i=0;i<discСode.length;i++)
        {
            if(discСode[i].equals(disc))
                return i+1;
        }
        return 0;
    }
}
