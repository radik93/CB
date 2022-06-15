package ru.cb.demo.models.clients;

import lombok.*;
import ru.cb.demo.models.bankaccount.CheckingAccount;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "clients")
@Getter
@Setter
public class Client {

    //Уникальный идентефикатор
    @Id
    @GeneratedValue
    private Long id;
    //Наименование компании
    @Column(name = "name")
    private String name;

    //Префикс
    @Column(name = "prefix")
    private String prefix;

    //Уникальный иденетфикатор
    @Column(name = "uniqueIdentifier")
    private String uniqueIdentifier;

    @OneToMany(targetEntity= CheckingAccount.class, fetch = FetchType.EAGER)
    @JoinColumn(name="clients_id")
    //Расчетные счета клиента
    private List<CheckingAccount> checkingAccounts = new ArrayList<>();
}
