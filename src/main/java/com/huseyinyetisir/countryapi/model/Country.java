package com.huseyinyetisir.countryapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Country {
    @Id
    String id;

    String name;

    String president;
}
