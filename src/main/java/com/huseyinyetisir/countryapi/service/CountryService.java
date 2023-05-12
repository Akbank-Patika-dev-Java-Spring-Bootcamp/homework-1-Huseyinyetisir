package com.huseyinyetisir.countryapi.service;


import com.huseyinyetisir.countryapi.dto.CountryDto;
import com.huseyinyetisir.countryapi.dto.CreateCountryRequest;
import com.huseyinyetisir.countryapi.dto.UpdatePresidentRequest;
import com.huseyinyetisir.countryapi.mapper.CountryMapper;
import com.huseyinyetisir.countryapi.model.Country;
import com.huseyinyetisir.countryapi.repository.CountryRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CountryService {

    private final CountryRepository countryRepository;

    private  final CountryMapper countryMapper;

//    public CountryService(CountryRepository countryRepository,CountryMapper countryMapper) {
//        this.countryRepository = countryRepository;
//        this.countryMapper = countryMapper;
//    }

    public CountryDto createCountry(CreateCountryRequest createCountryRequest) {
        Country country = new Country();
        country.setId(createCountryRequest.getId());
        country.setName(createCountryRequest.getName());
        country.setPresident(createCountryRequest.getPresident());

        countryRepository.save(country);
        return countryMapper.toCountryDto(country);

    }

    public List<CountryDto> getAllCountry(){
        List<Country> countryList = countryRepository.findAll();
        List<CountryDto> countryDtoList = new ArrayList<>();

        for (Country country:countryList){
            countryDtoList.add(countryMapper.toCountryDto(country));
        }
        return countryDtoList;
    }
    public CountryDto getCountryById(String id) {
        Optional<Country> countryOptional = countryRepository.findById(id);

        if (countryOptional.isPresent()) {
            Country country = countryOptional.get();

            if (countryMapper != null) {
                return countryMapper.toCountryDto(country);
            } else {
                throw new IllegalStateException("Country is null");
            }
        } else {
            return new CountryDto();
        }

    }

    public CountryDto updatePresident(UpdatePresidentRequest updatePresidentrequest) {
        Optional<Country> countryOptional = countryRepository.findById(updatePresidentrequest.getId());

        countryOptional.ifPresent(country -> {
            country.setId(updatePresidentrequest.getId());
            country.setPresident(updatePresidentrequest.getPresident());
            countryRepository.save(country);

        });
        return countryOptional.map(countryMapper::toCountryDto).orElse(new CountryDto());
    }

}
