package ru.cb.demo.models.emforms;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.cb.demo.models.abstrforms.ED1XX;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/*
Entity – это сущность,
 которая является отображением в базе данных
 */
@Entity
/*
используется для создания конструктора без аргументов
 */
@NoArgsConstructor
/*
генерирует параметризованный конструктор, который принимает один параметр
для каждого поля и инициализирует их с его помощью
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
/*
Эта аннотация используется для определения столбца дискриминатора
для Single_Table и объединенной стратегии.
 */
@DiscriminatorValue("ED108")
public class ED108 extends ED1XX {

    //Номер записи в реестре
    @Column(name = "transactionID")
    private int transactionID;

    //Расчетный счет
    @Column(name = "RS")
    private int RS;

    //БИК
    @Column(name = "BIK")
    private int BIK;

    //ИНН
    @Column(name = "INN")
    private int INN;

    //Корреспондентский счет
    @Column(name = "correspondentAccount")
    private int correspondentAccount;

    //Банк получатель
    @Column(name = "bankOfRecipient")
    private String bankOfRecipient;

    //Сумма оплаты
    @Column(name = "SUM")
    private float SUM;

    public ED108(int RS, int BIK, int INN, int correspondentAccount, String bankOfRecipient, float SUM) {
        this.RS = RS;
        this.BIK = BIK;
        this.INN = INN;
        this.correspondentAccount = correspondentAccount;
        this.bankOfRecipient = bankOfRecipient;
        this.SUM = SUM;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getRS() {
        return RS;
    }

    public void setRS(int RS) {
        this.RS = RS;
    }

    public int getBIK() {
        return BIK;
    }

    public void setBIK(int BIK) {
        this.BIK = BIK;
    }

    public int getINN() {
        return INN;
    }

    public void setINN(int INN) {
        this.INN = INN;
    }

    public int getCorrespondentAccount() {
        return correspondentAccount;
    }

    public void setCorrespondentAccount(int correspondentAccount) {
        this.correspondentAccount = correspondentAccount;
    }

    public String getBankOfRecipient() {
        return bankOfRecipient;
    }

    public void setBankOfRecipient(String bankOfRecipient) {
        bankOfRecipient = bankOfRecipient;
    }

    public float getSUM() {
        return SUM;
    }

    public void setSUM(float SUM) {
        this.SUM = SUM;
    }
}
