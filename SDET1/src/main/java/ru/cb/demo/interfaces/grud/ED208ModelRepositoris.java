package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.ED208;

@Repository
public interface ED208ModelRepositoris extends CrudRepository<ED208,Long> {
}

