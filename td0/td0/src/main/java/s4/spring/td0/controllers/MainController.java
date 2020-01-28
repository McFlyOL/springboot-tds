package s4.spring.td0.controllers;

import java.util.ArrayList;
import java.util.List;

import s4.spring.td0.models.Element;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

@SessionAttributes("items")
@Controller
public class MainController {

    @GetMapping("/items")
    public String listItems(){
        return "items";
    }
    
    @ModelAttribute("items") 
    public List<Element> getItems(){
        ArrayList<Element> array = new ArrayList<Element>();
        array.add(new Element("Gallier",7));
        array.add(new Element("Lefranc",9));
        return array;
    }

    /**
     * Affichage du formulaire de saisie
     * @return
     */
    @GetMapping("/items/new")
    public String newElementForm(){
        return "newElement";
    }

    /**
     * Validation du formulaire
     * @param nom passé par le POST du form
     * @param items en session
     * @return
     */
    @PostMapping("items/addNew")
    public RedirectView addNew(@RequestParam String nom,@SessionAttribute List<Element> items) {
        items.add(new Element(nom,10));
        return new RedirectView("/items/");
    }

    @GetMapping("/items/inc/{nom}")
    public RedirectView increase(@RequestParam String nom,@SessionAttribute List<Element> items){
        
        for(Element element : items){
            if(element.equals(nom)){
                element.setEvaluation(element.getEvaluation()+1);
            }
        }
        return new RedirectView("/items/");
    }

    @GetMapping("/items/dec/{nom}")
    public RedirectView decrease(@RequestParam String nom,@SessionAttribute List<Element> items){
        for(Element element : items){
            if(element.equals(nom)){
                element.setEvaluation(element.getEvaluation()-1);
            }
        }
        return new RedirectView("/items/");
    }
}