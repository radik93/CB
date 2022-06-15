package ru.cb.demo.utils;

public class DescErr208 {
    private static final String[] ctrlDesc  =
            //Ошибкки в реквизитаз ED243 ED244
                    {"",
                    "Успешное прохождение всех предусмотренных проверок ВЦ",
                    "Успешная доставка ЭС участнику – получателю запроса",
                    "Ошибка доставки ЭС участнику – получателю запроса"};


    public static String getDescCtrlED208(int errCode) {
        return ctrlDesc[errCode];
    }
}
