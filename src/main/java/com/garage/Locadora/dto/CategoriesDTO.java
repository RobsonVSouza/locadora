package com.garage.Locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriesDTO {

    private Long id;

    private String name;

    private String description;

    private Instant createdAt;
}
