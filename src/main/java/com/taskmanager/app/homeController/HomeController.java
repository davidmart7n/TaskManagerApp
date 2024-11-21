package com.taskmanager.app.homeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";  // Redirige a la vista "index.html"
    }
}