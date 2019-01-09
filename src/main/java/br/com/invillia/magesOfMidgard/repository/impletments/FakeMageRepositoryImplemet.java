package br.com.invillia.magesOfMidgard.repository.impletments;

import br.com.invillia.magesOfMidgard.model.Mage;
import br.com.invillia.magesOfMidgard.repository.FakeMageRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**Implementação do Repository criado para gerenciar os magos.
No spring JPA, classes como essa podem ser usadas para implementar consultas especializadas**/
@Component /** Notação de stereotype, dizendo que essa classe é um componente **/
public class FakeMageRepositoryImplemet implements FakeMageRepository {

    public List<Mage> fakeMageBD; /** Lista para salvar os magos em mémoria, para abstrair o banco **/

    /** Construtor que inicializa a lista**/
    public FakeMageRepositoryImplemet(List<Mage> fakeMageBD) {
        this.fakeMageBD = new ArrayList<>();
    }

    /**Método que percorre a lista usando stream(), para encontrar o mago pelo id**/
    @Override
    public Mage findById(Long id) {
       return fakeMageBD.stream().filter(mage -> id.equals(mage.getId())).findFirst().orElse(null);
    }

    /**Adiciona um id no mago e salva ele na lista**/
    @Override
    public void save(Mage m) {
        m.setId((long) fakeMageBD.size() + 1);
        fakeMageBD.add(m);

    }
    /**Atualiza o mago já salvo na lista salvo **/
    @Override
    public void update(Mage m) {
        Mage oldMage = findById(m.getId());
        fakeMageBD.add(fakeMageBD.indexOf(oldMage), m);
        fakeMageBD.remove(fakeMageBD.indexOf(oldMage));

    }
    /**Deleta o mago da lista pelo id **/
    @Override
    public void delete(Long id) {
        Mage m = findById(id);
        fakeMageBD.remove(fakeMageBD.indexOf(m));
    }
    /** Lista todos os magos **/
    @Override
    public List<Mage> findAll() {
        return fakeMageBD;
    }
}
