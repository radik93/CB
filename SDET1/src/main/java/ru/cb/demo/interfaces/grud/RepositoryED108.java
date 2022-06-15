package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.emforms.ED108;

/*
 * Интерфейс для реализации высокоуровневой абстракцией доступа
 * к формам ED108
 * @author radik
 * @version 1.0
 */
@Repository
public interface RepositoryED108  extends CrudRepository<ED108,Long> {
}
