package com.huseyinyetisir.countryapi.service;


import com.huseyinyetisir.countryapi.dto.CountryDto;
import com.huseyinyetisir.countryapi.dto.CountryDtoConverter;
import com.huseyinyetisir.countryapi.dto.CreateCountryRequest;
import com.huseyinyetisir.countryapi.dto.UpdatePresidentRequest;
import com.huseyinyetisir.countryapi.model.Country;
import com.huseyinyetisir.countryapi.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    private final CountryDtoConverter countryDtoConverter;

    public CountryService(CountryRepository countryRepository, CountryDtoConverter countryDtoConverter) {
        this.countryRepository = countryRepository;
        this.countryDtoConverter = countryDtoConverter;
    }

    public CountryDto createCountry(CreateCountryRequest createCountryRequest) {
        Country country = new Country();
        country.setId(createCountryRequest.getId());
        country.setName(createCountryRequest.getName());
        country.setPresident(createCountryRequest.getPresident());

        countryRepository.save(country);
        return countryDtoConverter.convert(country);
    }

    public List<CountryDto> getAllCountry(){
        List<Country> countryList = countryRepository.findAll();
        List<CountryDto> countryDtoList = new ArrayList<>();

        for (Country country:countryList){
            countryDtoList.add(countryDtoConverter.convert(country));
        }
        return countryDtoList;
    }
    public CountryDto getCountryById(String id) {
        Optional<Country> userOptional = countryRepository.findById(id);
        return userOptional.map(countryDtoConverter::convert).orElse(new CountryDto());
    }

    public CountryDto updatePresident(UpdatePresidentRequest updatePresidentrequest) {
        Optional<Country> countryOptional = countryRepository.findById(updatePresidentrequest.getId());

        countryOptional.ifPresent(country -> {
            country.setId(updatePresidentrequest.getId());
            country.setPresident(updatePresidentrequest.getPresident());
            countryRepository.save(country);

        });
        return countryOptional.map(countryDtoConverter::convert).orElse(new CountryDto());
    }


}
