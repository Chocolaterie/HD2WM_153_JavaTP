package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bo.Member;
import eni.tp.app.eni_app.ihm.EniFlashMessage;
import eni.tp.app.eni_app.ihm.EniIHMHelpers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes({"loggedUser"})
@Controller
public class AuthController {

    @GetMapping("login")
    public String showLogin(Model model, RedirectAttributes redirectAttributes) {
        // Tester si deja connecté (le user "loggedUser" en session n'est pas null) retourner page d'erreur
        Member loggedUser = (Member) model.getAttribute("loggedUser");

        if (loggedUser != null){
            // Ajouter un message temporaire (flash message)
            EniIHMHelpers.sendCommonFlashMessage(redirectAttributes, EniFlashMessage.TYPE_FLASH_ERROR,"Erreur vous êtes déjà connecte(é)");

            return "redirect:/";
        }

        // Instancier un User vide (email et password vide)
        Member user = new Member();

        // Envoyer le user dans le Model
        model.addAttribute("user", user);

        // Afficher la page qui contient le formulaire
        return "auth/login-page";
    }

    @PostMapping("login")
    public String processLogin(@ModelAttribute Member user, Model model, RedirectAttributes redirectAttributes) {
        // Mettre l'user dans la session
        model.addAttribute("loggedUser", user);

        // Ajouter un message temporaire (flash message)
        EniIHMHelpers.sendSuccessFlashMessage(redirectAttributes,"Vous êtes connecté(e) avec succès");

        // rediriger sur ta page d'accueil
        return "redirect:/";
    }

    @GetMapping("logout")
    public String logout(SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
        // nettoyer la session (se déconnecter)
        sessionStatus.setComplete();

        // Ajouter un message temporaire (flash message)
        EniIHMHelpers.sendSuccessFlashMessage(redirectAttributes,"Vous êtes déconnecté(e)");

        // rediriger à la page d'accueil
        return "redirect:/";
    }
}
