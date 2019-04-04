package com.marom.thymeleafpagination;

import com.marom.thymeleafpagination.domain.Country;
import com.marom.thymeleafpagination.repositories.CountryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class DataLoader implements CommandLineRunner {

    private CountryRepository countryRepository;

    public DataLoader(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCountries();
    }

    private void loadCountries() {

        for (Locale locale : Locale.getAvailableLocales()) {
            if ((locale.getDisplayCountry() != null) && (!"".equals(locale.getDisplayCountry()))) {
                final Country country = new Country();
                country.setCode(locale.getCountry());
                country.setName(locale.getDisplayCountry());
                country.setLanguage(locale.getDisplayLanguage());
                countryRepository.save(country);
            }
        }
    }
}
