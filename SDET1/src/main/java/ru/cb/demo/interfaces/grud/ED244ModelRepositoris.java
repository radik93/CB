package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.ED244;

/*
 * Интерфейс для работы с таблицей БД ED244
 * данная таблица содержит списко форм ED244
 * @author radik
 * @version 1.0
 */
@Repository
public interface ED244ModelRepositoris extends CrudRepository<ED244,Long> {
}
