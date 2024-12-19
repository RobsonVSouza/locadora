package com.garage.Locadora.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customers implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String birthDate;

    @Email
    private String email;

    private String driverLicense;

    private String adress;

    private String phoneNumber;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        this.createdAt = now; // Configura createdAt no momento da criação
        this.updatedAt = now; // Configura updatedAt no momento da criação
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = Instant.now(); // Atualiza updatedAt sempre que a entidade for modificada
    }

}
