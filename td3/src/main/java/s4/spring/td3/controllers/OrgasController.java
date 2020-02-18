package s4.spring.td3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.view.RedirectView;

import s4.spring.td3.entities.Groupe;
import s4.spring.td3.entities.Organization;
import s4.spring.td3.repositories.GroupeRepository;
import s4.spring.td3.repositories.OrgaRepository;

@Controller
@RequestMapping(
        method={RequestMethod.POST,RequestMethod.GET}
)
public class OrgasController {

    @Autowired
    private OrgaRepository repoOrga;

    @Autowired
    private GroupeRepository repoGroupe;

    @GetMapping({"/orgas", "" ,"/"})
    public String viewListeCategorie(ModelMap model){

        List<Organization> orgas = repoOrga.findAll();
        model.put("orgas", orgas);

        return "index";
    }

    @GetMapping("/new")
    public String pathNew()
    {
        return "addOrga";
    }
    @PostMapping("/orgas/doneAdd")
    public RedirectView addNewOrganization(@RequestParam String nom, @RequestParam String domain, @RequestParam String alias){
        Organization organization = new Organization(nom,domain,alias);
        repoOrga.save(organization);

        return new RedirectView("/orgas");
    } 

    @GetMapping(value="/orgas/edit/{id}")
    public String pathEditOrganization(ModelMap model, @PathVariable int id) {
        Organization organization = repoOrga.findById(id);
        if (organization != null){
            model.put("orga", organization);
            return "editOrgas";
        }else{
            return "";
        }
    }

    @PostMapping("orgas/edit")
    public RedirectView addEditOrga(@RequestParam int id, @RequestParam String nom, @RequestParam String domain, @RequestParam String alias) {
        Organization organization = repoOrga.findById(id);
        organization.setName(nom);
        organization.setDomain(domain);
        organization.setAliases(alias);

        repoOrga.save(organization);

        return new RedirectView("/orgas");
    }

    @PostMapping("orgas/delete/{id}")
    public RedirectView deleteOrga(@PathVariable int id) {
        Organization organization = repoOrga.findById(id);
        if (organization != null){
            repoOrga.delete(organization);
        }
        return new RedirectView("/orgas");
    }

    @GetMapping("/orgas/display/{id}")
    public String displayOrga(ModelMap model, @PathVariable int id){
        Organization organization = repoOrga.findById(id);
        List<Groupe> listeG = repoGroupe.findAll();

        model.put("orga", organization);
        model.put("listeGroupe", listeG);
        
        return "displayOrga";
    }
}