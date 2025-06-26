package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String page1() {
        // Redirect the root URL to the JSF page jetinfo.xhtml
        // return "redirect:/resolve-day-of-week.xhtml";
        return "redirect:/home.xhtml";
    }
    
    @GetMapping("/home")
    public String page1a() {
        // Redirect the root URL to the JSF page jetinfo.xhtml
        // return "redirect:/resolve-day-of-week.xhtml";
        return "home";
    }
    
    @GetMapping("/about")
    public String page2() {
        // Redirect the root URL to the JSF page jetinfo.xhtml
        return "about";
    }

    @GetMapping("/contact")
    public String page3() {
        // Redirect the root URL to the JSF page jetinfo.xhtml
        return "contact";
    }

    @GetMapping("/day-of-week")
    public String page4() {
        // Redirect the root URL to the JSF page jetinfo.xhtml
        return "resolve-day-of-week";
    }   
    
}
