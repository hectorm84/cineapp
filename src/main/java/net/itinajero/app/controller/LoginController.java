package net.itinajero.app.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){

        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(request, null, null);

        return "redirect:/formLogin";
    }
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String mostrasPrincipalAdmin(Authentication authentication){
        System.out.println("Username: " + authentication.getName());
        return "admin";
    }

}
