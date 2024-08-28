package eni.tp.app.eni_app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class EniWebConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        // Instancier un local resolver de type Session
        SessionLocaleResolver slr = new SessionLocaleResolver();

        // La langue par défaut (en anglais)
        slr.setDefaultLocale(Locale.ENGLISH);

        return slr;
    }
}
