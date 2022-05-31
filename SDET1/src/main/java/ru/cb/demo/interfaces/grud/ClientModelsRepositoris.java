package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.Client;

import java.util.List;
/*
 * Интерфейс для работы с таблицей БД clients
 * данная таблица содержит списко клиентов обмениваемых ЭС
 * @author radik
 * @version 1.0
 */
@Repository
public interface ClientModelsRepositoris extends CrudRepository<Client,Long> {
   /*
    * Метод для получения клиента по УИП
    * @return Везвращает список клиентов с данным УИП как правило  такой клиент только 1
    * @author radik
    * @version 1.0
    */
   List<Client> findClientsByEdReceiver(int edReceiver);
}

