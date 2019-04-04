package com.marom.thymeleafpagination.controllers;

import com.marom.thymeleafpagination.repositories.CountryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountryController {

    private CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }


    @GetMapping("/all")
    public String listAllCountries(Model model, @RequestParam(defaultValue = "0") int page) {
        //showPage(@PageableDefault(size=4)Pageable pageable)

        model.addAttribute("countries", countryRepository.findAll(PageRequest.of(page, 8)));
        model.addAttribute("currentPage", page);

        return "allCountries";
    }

}
