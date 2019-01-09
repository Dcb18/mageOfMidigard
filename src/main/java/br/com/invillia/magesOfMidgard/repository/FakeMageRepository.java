package br.com.invillia.magesOfMidgard.repository;

import br.com.invillia.magesOfMidgard.model.Mage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


/** Interface criada para abstrarair quais métodos seram usados no crud
Quando se usa Spring JPA, esse repositorio ira implementar classes desses frameworks,
 para abstrair métodos mais comuns de acesso a banco.
 Para a aula que será dada, não estarei usando o Spring JPA, porque ele será visto depois **/
@Repository
public interface FakeMageRepository  {
    Mage findById(Long id);
    void save(Mage mage);
    void update(Mage mage);
    void delete(Long id);
    List<Mage> findAll();
}
