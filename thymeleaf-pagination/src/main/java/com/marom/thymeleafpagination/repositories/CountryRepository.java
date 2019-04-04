package com.marom.thymeleafpagination.repositories;

import com.marom.thymeleafpagination.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
