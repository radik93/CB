package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.clients.Client;

import java.util.List;

/*
 * Интерфейс для реализации высокоуровневой абстракцией доступа
 * к клиентам банка
 * @author radik
 * @version 1.0
 */
@Repository
public interface RepositoryClients extends CrudRepository<Client,Long> {
    /*
     * Метод для получения списка клиентов по имени
     * принимает в качестве параметра наименование компании
     * @return Везвращает List из клиентов удовлетворяющих услови ю запроса
     * @author radik
     * @version 1.0
     */
    List<Client> findClientsByName(String name);
}
