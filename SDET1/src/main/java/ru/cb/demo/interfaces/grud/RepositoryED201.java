package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.emforms.ED201;

/*
 * Интерфейс для реализации высокоуровневой абстракцией доступа
 * к формам ED201
 * @author radik
 * @version 1.0
 */
@Repository
public interface RepositoryED201 extends CrudRepository<ED201,Long> {
}
