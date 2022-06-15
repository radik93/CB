package ru.cb.demo.models.abstrforms;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
@DiscriminatorColumn(name = "ed2xx")
/*
Классы в Java могут вступать в наследственные отношения и эти отношения.
Для этого у базового класса в аннотации @Inheritance указывается стратегия strategy = InheritanceType.TABLE_PER_CLASS,
 а у производных классов опять ничего не указывается
 */
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/*
Имя таблицы в БД
 */
@Table(name = "ed2xx")
/*
Абстрактный класс для наследования класса
документов типа ED243 ED244
 */
public abstract class ED2XX {

    //уникальный идентефикатор
    @Id
    @GeneratedValue
    private Long id;

    //уникальный номер документа
    @Column(name = "ecno")
    protected String ecno;

    //дата документа
    @Column(name = "edDate")
    private long edDate;

    //Уникальный иденетфикатор составителя
    @Column(name = "edСompiler")
    private String edСompiler;

    //Уникальный иденетфикатор получателя
    @Column(name = "edReceiver")
    private String edReceiver;

    @OneToMany(targetEntity=ED1XX.class, fetch = FetchType.EAGER)
    @JoinColumn(name="ed2xx_id")
    //Дочерние связанные документы унаследованный от ed1XX
    private List<ED1XX> ed1XXES = new ArrayList<>();

    @OneToOne(targetEntity=ED2XX.class, fetch = FetchType.EAGER)
    @JoinColumn(name="ed2xx_id")
    //Дочерние связанные документы унаследованный от ed1XX
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

    public void setEdDate(long edDate) {
        this.edDate = edDate;
    }

    public String getEdСompiler() {
        return edСompiler;
    }

    public void setEdСompiler(String edСompiler) {
        this.edСompiler = edСompiler;
    }

    public String getEdReceiver() {
        return edReceiver;
    }

    public void setEdReceiver(String edReceiver) {
        this.edReceiver = edReceiver;
    }

    public List<ED1XX> getEd1XXES() {
        return ed1XXES;
    }

    public void setEd1XXES(List<ED1XX> ed1XXES) {
        this.ed1XXES = ed1XXES;
    }

    public ED2XX getEd2XX() {
        return ed2XX;
    }

    public void setEd2XX(ED2XX ed2XX) {
        this.ed2XX = ed2XX;
    }
}
