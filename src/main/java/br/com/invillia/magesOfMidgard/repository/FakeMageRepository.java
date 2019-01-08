package br.com.invillia.magesOfMidgard.repository;

import br.com.invillia.magesOfMidgard.model.Mage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FakeMageRepository  {
    Mage findById(Long id);
    Mage save(Mage mage);
    Mage update(Mage mage);
    void delete(Long id);
    List<Mage> findAll();
}
