package br.com.invillia.magesOfMidgard.service;

import br.com.invillia.magesOfMidgard.model.Mage;
import br.com.invillia.magesOfMidgard.repository.FakeMageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/** Classe da camada de serviço, onde devem ser implementadas as regras de négocio da aplicação **/
@Service /** Notação de Stereotype, indicando que sua classe é um serviço **/
public class MageService {

    @Autowired /** injeta as dependencias da clase de repositorio**/
    private FakeMageRepository fakeMageRepository;

    public void save(Mage mage) {
        fakeMageRepository.save(mage);
    }

    public void upadte(Mage mage) {
        fakeMageRepository.update(mage);
    }

    public void delete(Long id) {
        fakeMageRepository.delete(id);
    }

    public List<Mage> findAll() {
        return fakeMageRepository.findAll();
    }

    public Mage findById(Long id) {
        return fakeMageRepository.findById(id);
    }

}
