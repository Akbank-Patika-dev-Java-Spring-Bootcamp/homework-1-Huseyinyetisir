package com.huseyinyetisir.countryapi.dto;


import com.huseyinyetisir.countryapi.model.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryDtoConverter {

    public CountryDto convert(Country country){
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        countryDto.setPresident(country.getPresident());

        return countryDto;
    }
}
