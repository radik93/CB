package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.*;
/*
 * Интерфейс для работы с таблицей БД ED108
 * данная таблица содержит списко форм ED108
 * @author radik
 * @version 1.0
 */
@Repository
public interface ED108ModelRepositoris  extends CrudRepository<ED108,Long> {
}
