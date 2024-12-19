package com.garage.Locadora.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RentalsDTO {

    private Long id;

    private Date startDate;

    private Date endtDate;

    private BigDecimal total;

    private Instant createdAt;

    private Instant updatedAt;
}
