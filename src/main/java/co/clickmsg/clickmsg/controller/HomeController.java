package co.clickmsg.clickmsg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author babafemi
 */
@Controller
public class HomeController {
    
    @GetMapping("")
    public String getHome(Model model) {
          
        return "redirect:/dashboard";
    }
}
