package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.ED208;
/*
 * Интерфейс для работы с таблицей БД ED208
 * данная таблица содержит списко форм ED208
 * @author radik
 * @version 1.0
 */
@Repository
public interface ED208ModelRepositoris extends CrudRepository<ED208,Long> {
}

