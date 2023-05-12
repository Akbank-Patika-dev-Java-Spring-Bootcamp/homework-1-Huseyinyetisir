package com.huseyinyetisir.countryapi.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Builder
public class UpdatePresidentRequest {

    String id;

    String president;
}
