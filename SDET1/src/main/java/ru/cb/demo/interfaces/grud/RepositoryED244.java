package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.emforms.ED244;

import java.util.List;

/*
 * Интерфейс для реализации высокоуровневой абстракцией доступа
 * к формам ED244
 * @author radik
 * @version 1.0
 */
@Repository
public interface RepositoryED244 extends CrudRepository<ED244,Long> {

    /*
     * Метод для получения списка ЭС по номеру
     * принимает в качестве параметра номер документа
     * @return Возвращает List из ЭС ED244 удовлетворяющих условию запроса
     * @author radik
     * @version 1.0
     */
    List<ED244> findED244sByEcno(String ecno);
}
