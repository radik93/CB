package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.ED244;

import java.util.List;

@Repository
public interface ED244ModelRepositoris extends CrudRepository<ED244,Long> {
    List<ED244> findFirstByEdReceiverAndEdAuthor(int edReceiver, int edAuthor);
}
