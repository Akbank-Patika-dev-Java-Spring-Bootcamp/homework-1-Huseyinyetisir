package com.huseyinyetisir.countryapi.repository;

import com.huseyinyetisir.countryapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,String> {
}
