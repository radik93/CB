package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.Client;

import java.util.List;

@Repository
public interface ClientModelsRepositoris extends CrudRepository<Client,Long> {
   List<Client> findClientsByEdReceiver(int edReceiver);
}

