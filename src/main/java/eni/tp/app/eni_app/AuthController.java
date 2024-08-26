package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bo.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@SessionAttributes({"loggedUser"})
@Controller
public class AuthController {

    @GetMapping("login")
    public String showLogin(Model model) {
        // Tester si deja connecté (le user "loggedUser" en session n'est pas null) retourner page d'erreur
        Member loggedUser = (Member) model.getAttribute("loggedUser");

        if (loggedUser != null){
            return "auth/already-logged-page";
        }

        // Instancier un User vide (email et password vide)
        Member user = new Member();

        // Envoyer le user dans le Model
        model.addAttribute("user", user);

        // Afficher la page qui contient le formulaire
        return "auth/login-page";
    }

    @PostMapping("login")
    public String processLogin(@ModelAttribute Member user, Model model) {
        // Mettre l'user dans la session
        model.addAttribute("loggedUser", user);

        // rediriger sur ta page d'accueil
        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(SessionStatus sessionStatus) {
        // nettoyer la session (se déconnecter)
        sessionStatus.setComplete();

        // rediriger à la page d'accueil
        return "redirect:/";
    }
}
