package s4.spring.td3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import io.github.jeemv.springboot.vuejs.VueJS;


@Controller
@RequestMapping(
        method={RequestMethod.POST,RequestMethod.GET}
)
public class TestController {

    @Autowired
    private VueJS vue;

    /*@GetMapping({"/orgas", "" ,"/"})
    public String index(ModelMap model){
        vue.addData("message","Test de message");
        model.put("vue",this.vue);
        return "index";
    }*/
}