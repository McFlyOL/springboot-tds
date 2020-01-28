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
        return new ArrayList<>();
    }

    @GetMapping("/items/new")
    public String newItems(){
        return "newItem";
    }

    @PostMapping("items/addNew")
    public RedirectView addNew(@RequestParam String nom,@SessionAttribute List<Element> items) {
        items.add(new Element(nom));
        return new RedirectView("/items/");
    }

    @GetMapping("/items/inc/{nom}")
    public RedirectView increase(@RequestParam String nom,@SessionAttribute List<Element> items){
        items.
        return new RedirectView("/items/");
    }

    @GetMapping("/items/dec/{nom}")
    public RedirectView decrease(@RequestParam String nom,@SessionAttribute List<Element> items){
        items.
        return new RedirectView("/items/");
    }
}