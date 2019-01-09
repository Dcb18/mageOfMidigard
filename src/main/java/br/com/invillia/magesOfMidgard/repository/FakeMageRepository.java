package br.com.invillia.magesOfMidgard.repository;

import br.com.invillia.magesOfMidgard.model.Mage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


/** Interface criada para abstrarair quais m�todos seram usados no crud
Quando se usa Spring JPA, esse repositorio ira implementar classes desses frameworks,
 para abstrair m�todos mais comuns de acesso a banco.
 Para a aula que ser� dada, n�o estarei usando o Spring JPA, porque ele ser� visto depois **/
@Repository
public interface FakeMageRepository  {
    Mage findById(Long id);
    void save(Mage mage);
    void update(Mage mage);
    void delete(Long id);
    List<Mage> findAll();
}
