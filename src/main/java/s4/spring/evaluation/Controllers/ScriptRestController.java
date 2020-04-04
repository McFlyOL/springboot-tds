package s4.spring.evaluation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import s4.spring.evaluation.models.*;
import s4.spring.evaluation.repositories.*;

import java.util.List;

@RestController
public class ScriptRestController
{
    @Autowired
    private repositoryScript repositoryScript;

    ScriptRestController(repositoryScript repo) {
        this.repositoryScript = repo;
    }

    @GetMapping("/rest/scripts")
    public List<Script> read(){
        return repositoryScript.findAll();
    }

    @GetMapping("/rest/script/{id}")
    public Script read(@PathVariable int id){
        return repositoryScript.findById(id);
    }

    @PostMapping("/rest/scripts/create")
    public void create(@RequestBody Script script){
        repositoryScript.saveAndFlush(script);
    }

    @PutMapping("/rest/scripts/update")
    public Script update(@RequestBody Script script){
        repositoryScript.findById(script.getId()).setTitle(script.getTitle());
        repositoryScript.findById(script.getId()).setCreationDate(script.getCreationDate());
        repositoryScript.findById(script.getId()).setDescription(script.getDescription());
        repositoryScript.findById(script.getId()).setContent(script.getContent());
        repositoryScript.findById(script.getId()).setUser(script.getUser());
        repositoryScript.findById(script.getId()).setCategory(script.getCategory());
        return repositoryScript.findById(script.getId());        
    }

    @DeleteMapping("/rest/script/delete/{id}")
    public void delete(@PathVariable int id){
        repositoryScript.deleteById(id);
    }

    @PostMapping(value = "/rest/search")
	public List<Script> recupererListes(@RequestBody Recherche script_recherche){
		String type_recherche = script_recherche.gettype_recherche();
        String script_recherchee = script_recherche.getScript_recherchee();
        
        switch (type_recherche) {
            case "titre":
                return repositoryScript.findByTitle(script_recherchee);
            case "description":
                return repositoryScript.findByDescription(script_recherchee);
            case "content":
                return repositoryScript.findByContent(script_recherchee);
            default:
                return null;
        }
	}
}