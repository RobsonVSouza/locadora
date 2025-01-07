package com.garage.Locadora.dto;

import com.garage.Locadora.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandDTO {

    private Long id;

    private String name;

    private Instant createdAt;

    private List<CarDTO> cars;
}
