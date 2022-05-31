package ru.cb.demo.interfaces.grud;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.cb.demo.models.ED243;

import java.util.List;

@Repository
public interface ED243ModelRepositoris extends CrudRepository<ED243,Long> {
   // List<ED243> findFirstByEdReceiverAndAnAnswer (int edReceiver,b);
  //  List<ED243> findED243sByEdReceiverAndIsAnAAndAnAnswer(int edReceiver, boolean anAnswer);
   // List<ED243> findED243sByEdReceiverAndAnAnswer(int edReceiver, boolean anAnswer);
   @Query(nativeQuery = true, value = "query = \"select ed243 from ED243 ed243 \" +\n" +
           "        \"where ed243.edReceiver = :edReceiver \" +\n" +
           "        \"and ed243.anAnswer=:anAnswer\")")
    List<ED243> findED243sByEdReceiverAndAnAnswer(int edReceiver, boolean anAnswer);
}
