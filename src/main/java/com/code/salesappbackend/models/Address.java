package com.code.salesappbackend.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "district")
    private String district;
    @Column(name = "city")
    private String city;
}
