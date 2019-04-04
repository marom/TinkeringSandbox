package com.marom.thymeleafpagination;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DataLoader implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        loadCountries();
    }

    private void loadCountries() {

        for (Locale locale : Locale.getAvailableLocales()) {
            if ((locale.getDisplayCountry() != null) && (!"".equals(locale.getDisplayCountry()))) {
                System.out.println(locale.getCountry() + "---" + locale.getDisplayCountry() + "---" + locale.getDisplayLanguage());
            }
        }
    }
}
