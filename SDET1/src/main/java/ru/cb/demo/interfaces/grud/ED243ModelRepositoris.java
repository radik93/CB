package ru.cb.demo.interfaces.grud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.ED243;

import java.util.List;
/*
 * Интерфейс для работы с таблицей БД ED243
 * данная таблица содержит списко форм ED243
 * @author radik
 * @version 1.0
 */
@Repository
public interface ED243ModelRepositoris extends CrudRepository<ED243,Long> {
    /*
     * Метод для ФОРМ ED243 на каторые клиент еще не ответил
     * @return Везвращает список ФОРМ ED243
     * @author radik
     * @version 1.0
     */
    List<ED243> findED243sByEdReceiverAndAnAnswer(int edReceiver, boolean anAnswer);

}
