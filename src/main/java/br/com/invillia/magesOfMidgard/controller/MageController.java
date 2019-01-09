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

@Controller /** Nota��o de stereotype, dizendo que essa classe � um controller **/
public class MageController {

    @Autowired /** injeta as dependencias da clase de servi�o**/
    private MageService mageService;

    /** M�todo que traz todos os magos cadastrados e renderiza a p�gina que os lista **/
    @GetMapping("/") /** Indica que o m�todo � um metodo do tipo get, e que o path dele � / **/
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("getMage");
        mv.addObject("mage", mageService.findAll());

        return mv;
    }
    /** M�todo que renderiza a pagina de cadastro e passa o objeto mago para ser criado ou editado**/
    @GetMapping("/add") /** Indica que o m�todo � um metodo do tipo get, e que o path dele � /add **/
    public ModelAndView add(Mage mage) {

        ModelAndView mv = new ModelAndView("postMage");
        Map <String, Object> att = new HashMap<>();
        att.put("mage", mage);
        att.put("elements", Element.values());
        mv.addAllObjects(att);
        return mv;
    }
    /** M�todo que busca o mago cadastrado e o encaminha para o metodo de cria��o, caso ele exista.
     * Se n�o existir, a pagina funcionara como um cadastro**/
    @GetMapping("/edit/{id}") /** Indica que o m�todo � um metodo do tipo get, e que o path dele � /edit/{id} sendo o {id}
     uma variavel que vem no path **/
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(mageService.findById(id));
    }
    /** M�todo que deleta o mago pelo id e recarega a pagina de listagem **/
    @GetMapping("/delete/{id}") /** Indica que o m�todo � um metodo do tipo get, e que o path dele � /delete/{id} sendo o {id}
     uma variavel que vem no path **/
    public ModelAndView delete(@PathVariable("id") Long id) {

        mageService.delete(id);

        return findAll();
    }
    /** M�todo que encaminha o objeto de mago para o m�doto que salva/atualiza o mago e redireciona para a tela de listagem **/
    @PostMapping("/save") /** Indica que o m�todo � um metodo do tipo post, e que o path dele � /save**/
    public ModelAndView save(Mage mage) {
        if(mage.getId() == null){
            mageService.save(mage);
        } else {
            mageService.upadte(mage);
        }
        return findAll();
    }

}
