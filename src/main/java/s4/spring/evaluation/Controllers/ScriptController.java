package s4.spring.evaluation.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.github.jeemv.springboot.vuejs.VueJS;
import io.github.jeemv.springboot.vuejs.utilities.Http;


@Controller
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class ScriptController
{

    @Autowired
    private VueJS vue;

    @GetMapping("script/search")
    public String search(ModelMap model) {
    	vue.addData("type_recherche");
        vue.addData("script_recherchee");

        vue.addDataRaw("scripts", "[]");
        vue.addDataRaw("headers", "[{text:'Titre', value:'title'}, {text:'Categorie', value:'category.name'}, {text:'Langage', value: 'language.name'}, {text:'Description', value:'description'}]");
        vue.addDataRaw("choices", "[{text:'Titre', value:'titre'},{text:'Description', value:'description'},{text:'Contenu', value:'content'}]");
        vue.addWatcher("type_recherche","this.rechercher();" );
        vue.addWatcher("script_recherchee","this.rechercher();" );

        vue.addMethod("rechercher", "let self=this;"+Http.post("/rest/search",(Object)"{'type_recherche': this.type_recherche, 'script_recherchee': this.script_recherchee}", "self.scripts = response.data;"));  
        model.put("vue",vue);

        return "recherche";
    }
}