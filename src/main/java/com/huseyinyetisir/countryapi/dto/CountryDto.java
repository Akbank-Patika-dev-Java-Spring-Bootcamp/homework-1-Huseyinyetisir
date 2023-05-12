package com.huseyinyetisir.countryapi.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {

    String id;

    String name;

    String president;
}
