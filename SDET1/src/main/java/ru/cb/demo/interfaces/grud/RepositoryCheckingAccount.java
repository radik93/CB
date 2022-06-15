package ru.cb.demo.interfaces.grud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.bankaccount.CheckingAccount;

/*
 * Интерфейс для реализации высокоуровневой абстракцией доступа
 * к данным расчетного счета
 * @author radik
 * @version 1.0
 */
@Repository
public interface RepositoryCheckingAccount  extends CrudRepository<CheckingAccount,Long> {
}
