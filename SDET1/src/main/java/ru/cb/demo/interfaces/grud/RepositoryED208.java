package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.emforms.ED208;

/*
 * Интерфейс для реализации высокоуровневой абстракцией доступа
 * к формам ED208
 * @author radik
 * @version 1.0
 */
@Repository
public interface RepositoryED208 extends CrudRepository<ED208,Long> {
}
