package s4.spring.td3.controllers;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import s4.spring.td3.entities.Organization;
import s4.spring.td3.repositories.GroupeRepository;
import s4.spring.td3.repositories.OrgaRepository;

@RestController
public class RestOrgasController {
    @Autowired
    private OrgaRepository repoOrga;

    @Autowired
    private GroupeRepository repoGroupe;

    RestOrgasController(OrgaRepository repo) {
        this.repoOrga = repo;
      }
    @GetMapping("/rest/orgas")
    public List<Organization> read(){
        return repoOrga.findAll();
    }

    @GetMapping("/rest/orgas/{id}")
    public Organization read(@PathVariable int id){
        return repoOrga.findById(id);
    }

    @PostMapping("/rest/orgas/create")
    public void create(@RequestBody Organization organization){
        repoOrga.saveAndFlush(organization);
    }

    @PutMapping("/rest/orgas/update")
    public Organization update(@RequestBody Organization organization){
            repoOrga.findById(organization.getId()).setName(organization.getName());
            repoOrga.findById(organization.getId()).setDomain(organization.getDomain());
            repoOrga.findById(organization.getId()).setAliases(organization.getAliases());
            return repoOrga.findById(organization.getId());        
    }

    @DeleteMapping("/rest/orgas/delete/{id}")
    public void delete(@PathVariable int id){
        repoOrga.deleteById(id);
    }

    @GetMapping("/rest/orgas/{member}/{id}")
    public Organization get(int id, User member){
        return repoOrga.findById(id);
    }
}