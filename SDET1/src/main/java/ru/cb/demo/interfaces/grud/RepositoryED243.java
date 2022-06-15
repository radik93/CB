package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.abstrforms.ED2XX;
import ru.cb.demo.models.emforms.ED243;

import java.util.List;

/*
 * Интерфейс для реализации высокоуровневой абстракцией доступа
 * к формам ED243
 * @author radik
 * @version 1.0
 */
@Repository
public interface RepositoryED243  extends CrudRepository<ED243,Long> {

    /*
     * Метод для получения списка ЭС по номеру
     * принимает в качестве параметра номер документа
     * @return Возвращает List из ЭС ED243 удовлетворяющих условию запроса
     * @author radik
     * @version 1.0
     */
    List<ED243> findED243sByEcno(String ecno);

    /*
     * Метод для получения списка ЭС по УИП и связанному документу
     * принимает в качестве параметра УИП и связанный документ
     * @return Возвращает List из ЭС ED243 удовлетворяющих условию запроса
     * @author radik
     * @version 1.0
     */
    List<ED243> findED243sByEdReceiverAndEd2XX(String EdReceiver,
                                               ED2XX ed2xx);
}
