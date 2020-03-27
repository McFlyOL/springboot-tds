package s4.spring.evaluation.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(
        method={RequestMethod.POST,RequestMethod.GET}
)
public class MainController {

    @GetMapping({"/",""})
    public String index(){
        return "index";
    }

    @GetMapping(value="/login")
    public String loginView() {
        return "";
    }

    @GetMapping(value = "/logout")
    public RedirectView logout()
    {
        return new RedirectView("/");
    }
    
}