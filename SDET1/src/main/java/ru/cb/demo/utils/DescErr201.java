package ru.cb.demo.utils;

public class DescErr201 {

    private static final String[] errDesc  =
            //Ошибкки в реквизитаз ED243 ED244
            {"Нет ошибки",
             "Не заполнена дата документа",
             "Не заполнен УИО",
             "Не заполнен УИП",
             "Не верно указан УИО",
             "Не верно указан УИП",
             "Не заполнен Код запроса",
             "Не заполнен Код ответа",
             "Не заполнен уникальный номер исходного документа",
             "Не заполнена дата исходного документа"};


    public static String getDescErrED201(int errCode) {
        return errDesc[errCode];
    }
}
