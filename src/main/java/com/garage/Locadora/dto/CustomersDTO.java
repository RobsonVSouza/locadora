package com.garage.Locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomersDTO {

    private Long id;

    private String name;

    private String birthDate;

    private String email;

    private String driverLicense;

    private String adress;

    private String phoneNumber;

    private Instant createdAt;

    private Instant updatedAt;
}
