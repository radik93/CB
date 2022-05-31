package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.ED201;

@Repository
public interface ED201ModelRepositoris extends CrudRepository<ED201,Long> {
}
