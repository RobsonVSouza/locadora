package com.garage.Locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarsSpecificationDTO {

    private Long id;

    private Long carId;

    private String carName;

    private Long specificationId;

    private String specificationName;
}
