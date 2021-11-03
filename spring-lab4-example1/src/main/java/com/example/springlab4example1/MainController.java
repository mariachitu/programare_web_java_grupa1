package com.example.springlab4example1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/test")
public class MainController {

//    http://localhost:9191/home
//    @RequestMapping(method = RequestMethod.GET, path = "/home")
//    //@GetMapping(path = "/home")
//    public String hello()   {
//        return "home.html";
//    }

    //http://localhost:9191/home/maria
    @GetMapping("/home/{name}")
    public String userHome(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "userhome.html";
    }

    //http://localhost:9191/parameter?name=maria
    @GetMapping("/parameter")
    public String parameterHome(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "parameterhome";
    }

    //http://localhost:9191/parameters?firstName=maria&lastName=chitu
    @GetMapping("/parameters")
    public String parametersHome(@RequestParam String firstName,
                                 @RequestParam String lastName,
                                 Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "parametershome";
    }
}
