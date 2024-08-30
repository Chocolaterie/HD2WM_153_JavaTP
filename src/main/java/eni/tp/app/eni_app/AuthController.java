package eni.tp.app.eni_app;

import eni.tp.app.eni_app.bll.AuthManager;
import eni.tp.app.eni_app.bll.EniManagerResponse;
import eni.tp.app.eni_app.bo.Member;
import eni.tp.app.eni_app.ihm.EniFlashMessage;
import eni.tp.app.eni_app.ihm.EniIHMHelpers;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes({"loggedUser"})
@Controller
public class AuthController {

    @Autowired
    AuthManager authManager;

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
    public String processLogin(@Valid @ModelAttribute(name = "user") Member user, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        // 1 :: Contrôle de surface

        // Erreur : Si controle de surface pas ok
        if (bindingResult.hasErrors()){
            // Retourner la page avec les erreurs de validation (le format)
            return "auth/login-page";
        }

        // 2 : Contrôle métier (le manager)
        EniManagerResponse<Member> response = authManager.authenticate(user.email, user.password);

        // Erreur code 756 retourner la page avec l'erreur métier
        if (response.code.equals("756")){
            // TODO : Pendant qu'on retourne la page de connexion (envoyer l'erreur metier)
            return "auth/login-page";
        }

        // 3 : Connecter l'user en session
        // Mettre l'user retrouvé en base dans la session
        model.addAttribute("loggedUser", response.data);

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
