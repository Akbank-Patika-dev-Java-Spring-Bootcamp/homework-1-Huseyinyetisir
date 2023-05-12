package com.huseyinyetisir.countryapi.controller;


import com.huseyinyetisir.countryapi.dto.CountryDto;
import com.huseyinyetisir.countryapi.dto.CreateCountryRequest;
import com.huseyinyetisir.countryapi.dto.UpdatePresidentRequest;
import com.huseyinyetisir.countryapi.service.CountryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CountryController {

    private CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryDto>createCountry(@RequestBody CreateCountryRequest createCountryRequest){
        return ResponseEntity.ok(countryService.createCountry(createCountryRequest));

    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDto> getCountryById(@PathVariable String id){
        return ResponseEntity.ok(countryService.getCountryById(id));
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAllCountry(){
        return ResponseEntity.ok(countryService.getAllCountry());
    }
    @PutMapping
    public ResponseEntity<CountryDto> updatePresident(@RequestBody UpdatePresidentRequest updatePresidentRequest){
        return ResponseEntity.ok(countryService.updatePresident(updatePresidentRequest));
    }


}
