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
@DiscriminatorValue("ED201")
public class ED201 extends ED1XX {

    //Код результата обработки
    @Column(name = "ctrlCode")
    private int ctrlCode;

    public int getCtrlCode() {
        return ctrlCode;
    }

    public void setCtrlCode(int ctrlCode) {
        this.ctrlCode = ctrlCode;
    }
}
