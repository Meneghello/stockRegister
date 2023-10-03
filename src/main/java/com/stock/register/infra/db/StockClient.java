package com.stock.register.infra.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockClient {

    @Id
    @Column(name = "client_cpf")
    private Long cpf;
    @Id
    @Column(name = "client_id", nullable = false,columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    @Column(name = "name")
    private String name;
    @Column(name = "secondName")
    private String secondName;
    @Column(name = "birthDate")
    private LocalDate birthDate;
    @CreationTimestamp
    @Column(name = "registration_date")
    private LocalDateTime registrationDate;
    @UpdateTimestamp
    @Column(name = "lastUpdate_date")
    private LocalDateTime lastUpdateDate;
    @Column(name = "active_register")
    private Boolean activeRegister;
}
