package com.garage.Locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarImageDTO {

    private Long id;

    private String image;

    private Instant createdAt;

    private Long carId;

    private String carName;
}
