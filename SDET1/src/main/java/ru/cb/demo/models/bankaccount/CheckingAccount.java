package ru.cb.demo.models.bankaccount;

import lombok.*;
import ru.cb.demo.models.clients.Client;

import javax.persistence.*;

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
/*
Имя таблицы в БД
 */
@Table(name = "checkingaccount")
@Getter
@Setter
@Builder
public class CheckingAccount {

    //Уникальный идентефикатор
    @Id
    @GeneratedValue
    private Long id;

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
    @Column(name = "BankOfRecipient")
    private String BankOfRecipient;

    @ManyToOne(targetEntity= Client.class)
    @JoinColumn(name="clients_id")
    //Владелец расчетного счета
    private Client client;


}
