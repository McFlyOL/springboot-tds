package s4.spring.td0.controllers;

import java.util.ArrayList;
import java.util.List;

import s4.spring.td0.models.Categorie;
import s4.spring.td0.models.Element;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public List<Categorie> getItems(){

        ArrayList<Categorie> array = new ArrayList<Categorie>();

        Categorie amis = new Categorie("Amis");
        amis.ajouter(new Element("Thomas le BG", 2)); 

        Categorie famille = new Categorie("Famille");
        famille.ajouter(new Element("EL PABLITO", 6));
        
        Categorie pro = new Categorie("Professionnels");
        pro.ajouter(new Element("Tom CRUISE", 10));

        array.add(amis);
        array.add(famille);
        array.add(pro);

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
    public RedirectView addNew(@RequestParam int note, @RequestParam String categorie, @RequestParam String nom, @SessionAttribute List<Categorie> items) {
        getListElement(categorie, items).ajouter(new Element(nom, note));
        return new RedirectView("/items");
    }

    public Categorie getListElement(String categorie, @SessionAttribute List<Categorie> items)
    {
        for (Categorie list_categorie : items) {
            if(list_categorie.equals(categorie))
                return list_categorie;
        }
        return null;
    }

    public Element getElement(String nom, @SessionAttribute List<Categorie> items)
    {
        for (Categorie categorie : items) {
            for (Element element  : categorie.getList()) {
                if(element.equals(nom))
                    return element;
            }
        }
        return null;
    }

    public Categorie getListNom(String nom, @SessionAttribute List<Categorie> items)
    {
        for (Categorie categorie : items) {
            for(Element element : categorie.getList())
            {
                if(element.equals(nom))
                    return categorie;
            }
        }
        return null;
    }
    @GetMapping("/items/inc/{nom}")
    public RedirectView increment(@PathVariable String nom, @SessionAttribute List<Categorie> items)
    {
        getElement(nom, items).setEvaluation(getElement(nom, items).getEvaluation()+1);
        return new RedirectView("/items");
    }


    @GetMapping("/items/dec/{nom}")
    public RedirectView decrease(@PathVariable String nom,@SessionAttribute List<Categorie> items){
        getElement(nom, items).setEvaluation(getElement(nom, items).getEvaluation()-1);
        return new RedirectView("/items");
    }

    @GetMapping("/items/delete/{nom}")
    public RedirectView delete(@PathVariable String nom,@SessionAttribute List<Categorie> items){
        getListNom(nom, items).getList().remove(getElement(nom, items));
        return new RedirectView("/items");
    }
}