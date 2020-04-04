package s4.spring.evaluation.Controllers;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import s4.spring.evaluation.repositories.repositoryCategory;
import s4.spring.evaluation.repositories.repositoryLanguage;
import s4.spring.evaluation.repositories.repositoryScript;
import s4.spring.evaluation.models.Language;
import s4.spring.evaluation.models.Script;
import s4.spring.evaluation.models.User;
import s4.spring.evaluation.models.Category;

@Controller
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class ScriptsController {

    @Autowired
    private repositoryScript repositoryScript;

    @Autowired
    private repositoryCategory repositoryCategory;

    @Autowired
    private repositoryLanguage repositoryLanguage;

    
    @GetMapping("script/new")
    public String newScript(ModelMap model, HttpSession session)
    {
        User user = (User)session.getAttribute("userC");
        if(user!=null) {
            List<Language> language = this.repositoryLanguage.findAll();
            List<Category> category = this.repositoryCategory.findAll();
            model.put("language", language);
            model.put("category", category);
            return "script/new";
        }
        else
        {
            return "login";
        }
    }

    @PostMapping(value= {"script/submit", "script/submit/{id}"})
    public RedirectView newScriptSubmit(@PathVariable(required = false) String id, @RequestParam String title, @RequestParam String date, @RequestParam String description,@RequestParam String language, @RequestParam String category, @RequestParam String content, HttpSession session){
        User user =  (User) session.getAttribute("userC");

        if(user!=null){
            if(id == null){
                Script script = new Script(title,description,content,date,repositoryLanguage.findByName(language),user,repositoryCategory.findByName(category));
                repositoryScript.saveAndFlush(script);
            }else{
                Script script = repositoryScript.findById(Integer.parseInt(id));
                script.setTitle(title);
                script.setDescription(description);
                script.setContent(content);
                script.setCreationDate(date);
                script.setUser(user);                
                Category category_update = repositoryCategory.findByName(category);
                script.setCategory(category_update);
                Language language_update = repositoryLanguage.findByName(language);
                script.setLanguage(language_update);
                repositoryScript.saveAndFlush(script);
                return new RedirectView("/index");
            }
        }
        return new RedirectView("/index");
    }

    @GetMapping("script/{id}")
    public String modifyScript(ModelMap model, @PathVariable int id, HttpSession session){
        if(session.getAttribute("userC")!=null){
            List<Language> language = this.repositoryLanguage.findAll();
            List<Category> category = this.repositoryCategory.findAll();
            model.put("language", language);
            model.put("category", category);
            model.put("script",repositoryScript.findById(id));
            return "script/edit";
        }else{
            return "login";
        }
    }
}