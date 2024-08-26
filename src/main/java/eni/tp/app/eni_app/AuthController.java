package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("login")
    public String showLogin(Model model) {
        // Instancier un User vide (email et password vide)
        Member user = new Member();

        // Envoyer le user dans le Model
        model.addAttribute("user", user);

        // Afficher la page qui contient le formulaire
        return "auth/login-page";
    }
}
