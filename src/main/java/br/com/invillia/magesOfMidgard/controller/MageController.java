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

@Controller
public class MageController {

    @Autowired
    private MageService mageService;

    @GetMapping("/")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView("getMage");
        mv.addObject("mage", mageService.findAll());

        return mv;
    }

    @GetMapping("/add")
    public ModelAndView add(Mage mage) {

        ModelAndView mv = new ModelAndView("postMage");
        Map <String, Object> att = new HashMap<>();
        att.put("mage", mage);
        att.put("elements", Element.values());
        mv.addAllObjects(att);
        return mv;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {

        return add(mageService.findById(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        mageService.delete(id);

        return findAll();
    }

    @PostMapping("/save")
    public ModelAndView save(Mage mage) {
        if(mage.getId() == null){
            mageService.save(mage);
        } else {
            mageService.upadte(mage);
        }
        return findAll();
    }

}
