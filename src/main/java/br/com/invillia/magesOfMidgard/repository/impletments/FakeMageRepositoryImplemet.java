package br.com.invillia.magesOfMidgard.repository.impletments;

import br.com.invillia.magesOfMidgard.model.Mage;
import br.com.invillia.magesOfMidgard.repository.FakeMageRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeMageRepositoryImplemet implements FakeMageRepository {

    public List<Mage> fakeMageBD;


    public FakeMageRepositoryImplemet(List<Mage> fakeMageBD) {
        this.fakeMageBD = new ArrayList<>();
    }

    @Override
    public Mage findById(Long id) {
       return fakeMageBD.stream().filter(mage -> id.equals(mage.getId())).findFirst().orElse(null);
    }

    @Override
    public Mage save(Mage m) {
        m.setId((long) fakeMageBD.size() + 1);
        fakeMageBD.add(m);
        return m;
    }

    @Override
    public Mage update(Mage m) {
        Mage oldMage = findById(m.getId());
        fakeMageBD.add(fakeMageBD.indexOf(oldMage), m);
        fakeMageBD.remove(fakeMageBD.indexOf(oldMage));
        return m;
    }

    @Override
    public void delete(Long id) {
        Mage m = findById(id);
        fakeMageBD.remove(fakeMageBD.indexOf(m));
    }

    @Override
    public List<Mage> findAll() {
        return fakeMageBD;
    }
}
