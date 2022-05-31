package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.ED108;

@Repository
public interface ED108ModelRepositoris  extends CrudRepository<ED108,Long> {
}
