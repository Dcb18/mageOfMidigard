package br.com.invillia.magesOfMidgard.controller;

import br.com.invillia.magesOfMidgard.model.Mage;
import br.com.invillia.magesOfMidgard.model.enums.Element;
import br.com.invillia.magesOfMidgard.service.MageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller /** Notação de stereotype, dizendo que essa classe é um controller **/
public class MageController {

    @Autowired /** injeta as dependencias da clase de serviço**/
    private MageService mageService;

    /** Método que traz todos os magos cadastrados e renderiza a página que os lista **/
    @GetMapping("/") /** Indica que o método é um metodo do tipo get, e que o path dele é / **/
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("getMage");
        mv.addObject("mage", mageService.findAll());

        return mv;
    }
    /** Método que renderiza a pagina de cadastro e passa o objeto mago para ser criado ou editado**/
    @GetMapping("/add") /** Indica que o método é um metodo do tipo get, e que o path dele é /add **/
    public ModelAndView add(Mage mage) {

        ModelAndView mv = new ModelAndView("postMage");
        Map <String, Object> att = new HashMap<>();
        att.put("mage", mage);
        att.put("elements", Element.values());
        mv.addAllObjects(att);
        return mv;
    }
    /** Método que busca o mago cadastrado e o encaminha para o metodo de criação, caso ele exista.
     * Se não existir, a pagina funcionara como um cadastro**/
    @GetMapping("/edit/{id}") /** Indica que o método é um metodo do tipo get, e que o path dele é /edit/{id} sendo o {id}
     uma variavel que vem no path **/
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(mageService.findById(id));
    }
    /** Método que deleta o mago pelo id e recarega a pagina de listagem **/
    @GetMapping("/delete/{id}") /** Indica que o método é um metodo do tipo get, e que o path dele é /delete/{id} sendo o {id}
     uma variavel que vem no path **/
    public ModelAndView delete(@PathVariable("id") Long id) {

        mageService.delete(id);

        return findAll();
    }
    /** Método que encaminha o objeto de mago para o médoto que salva/atualiza o mago e redireciona para a tela de listagem **/
    @PostMapping("/save") /** Indica que o método é um metodo do tipo post, e que o path dele é /save**/
    public ModelAndView save(Mage mage) {
        if(mage.getId() == null){
            mageService.save(mage);
        } else {
            mageService.upadte(mage);
        }
        return findAll();
    }

}
