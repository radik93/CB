package ru.cb.demo.models.abstrforms;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
@DiscriminatorColumn(name = "ed1xx")
/*
Классы в Java могут вступать в наследственные отношения и эти отношения.
Для этого у базового класса в аннотации @Inheritance указывается стратегия strategy = InheritanceType.TABLE_PER_CLASS,
 а у производных классов опять ничего не указывается
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/*
Имя таблицы в БД
 */
@Table(name = "ed1xx")

/*
Абстрактный класс для наследования класса
документов типа ED201 ED208 ED108
 */
public abstract class ED1XX {
    //Уникальный идентефикатор
    @Id
    @GeneratedValue
    private Long id;
    //Уникальный номер документа
    @Column(name = "ecno")
    private String ecno;
    //Дата документа
    @Column(name = "edDate")
    private long edDate;

    @ManyToOne(targetEntity=ED2XX.class)
    @JoinColumn(name="ed2xx_id")
    //Родительский документ унаследованный от ed2XX
    private ED2XX ed2XX;

    public String getEcno() {
        return ecno;
    }

    public void setEcno(String ecno) {
        this.ecno = ecno;
    }

    public long getEdDate() {
        return edDate;
    }

    public Long getId() {
        return id;
    }

    public void setEdDate(long edDate) {
        this.edDate = edDate;
    }

    public ED2XX getEd2XX() {
        return ed2XX;
    }

    public void setEd2XX(ED2XX ed2XX) {
        this.ed2XX = ed2XX;
    }
}
