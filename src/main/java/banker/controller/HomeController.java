package banker.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shaziya on 30/3/18.
 */
@Controller
public class HomeController
{
    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
