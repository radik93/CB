package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import ru.cb.demo.models.Client;

import java.util.List;

public interface ClientModelsRepositoris extends CrudRepository<Client,Long> {
   List<Client> findClientsByEdReceiver(int edReceiver);
}

