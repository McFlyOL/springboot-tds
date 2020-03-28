package s4.spring.evaluation.Controllers;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.evaluation.repositories.repositoryCategory;
import s4.spring.evaluation.repositories.repositoryHistory;
import s4.spring.evaluation.repositories.repositoryLanguage;
import s4.spring.evaluation.repositories.repositoryScript;
import s4.spring.evaluation.repositories.repositoryUser;
import s4.spring.evaluation.models.Language;
import s4.spring.evaluation.models.Script;
import s4.spring.evaluation.models.User;
import s4.spring.evaluation.models.Category;

@Controller
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class MainController {

    @Autowired
    private repositoryUser repositoryUser;

    @Autowired
    private repositoryCategory repositoryCategory;

    @Autowired
    private repositoryLanguage repositoryLanguage;

    @ModelAttribute("userC")
    public User userC() {
        return new User();
    }

    @GetMapping("/")
    public String home(ModelMap model){
        return "login";
    }

    @GetMapping("/index")
    public String indexView(ModelMap model, HttpSession session)
    {
        if(session.getAttribute("userC")!=null){
            model.addAttribute("userC", session.getAttribute("userC"));
            model.put("connection",true);
            return "index";
        }
        return "index";   
    }

    @GetMapping("/login")
    public String indexLogin()
    {
        return "login";        
    }

    @PostMapping("/verifLogin")
    public RedirectView login(@RequestParam String name, @RequestParam String password, HttpSession session,RedirectAttributes attribute)
    {
        User user = this.repositoryUser.findByFirstname(name);
        if(user!=null)
        {
            if(user.getPassword().equals(password))
            {
                session.setAttribute("userC", user);
                return new RedirectView("/index");
            }
        }
        attribute.addFlashAttribute("prob_co", "Oops, les identifiants ne sont pas corrects !");
        return new RedirectView("/login");
    }

    @GetMapping("logout")
    public RedirectView logout(HttpSession session, RedirectAttributes attribute, ModelMap model)
    {
        session.removeAttribute("userC");
        model.remove("connection");
        attribute.addFlashAttribute("message_deco", "Vous avez été deconnecté de votre compte !");
        return new RedirectView("/index");
    }

}