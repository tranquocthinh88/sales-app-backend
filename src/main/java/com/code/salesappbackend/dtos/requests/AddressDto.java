package com.code.salesappbackend.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;


@Getter
@Setter
@Builder
public class AddressDto implements Serializable {
    @NotBlank(message = "street must be not blank")
    String street;
    @NotBlank(message = "district must be not blank")
    String district;
    @NotBlank(message = "city must be not blank")
    String city;
}