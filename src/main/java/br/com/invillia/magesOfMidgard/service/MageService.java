package br.com.invillia.magesOfMidgard.service;

import br.com.invillia.magesOfMidgard.model.Mage;
import br.com.invillia.magesOfMidgard.repository.FakeMageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MageService {

    @Autowired
    private FakeMageRepository fakeMageRepository;

    public Mage save(Mage mage) {
        return fakeMageRepository.save(mage);
    }

    public Mage upadte(Mage mage) {
        return fakeMageRepository.update(mage);
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
