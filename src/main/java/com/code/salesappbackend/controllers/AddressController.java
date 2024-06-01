package com.code.salesappbackend.controllers;

import com.code.salesappbackend.dtos.requests.AddressDto;
import com.code.salesappbackend.dtos.responses.ResponseError;
import com.code.salesappbackend.dtos.responses.ResponseSuccess;
import com.code.salesappbackend.mapper.AddressMapper;
import com.code.salesappbackend.models.Address;
import com.code.salesappbackend.services.interfaces.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @PostMapping
    public ResponseSuccess<?> addAddress(@RequestBody @Valid AddressDto addressDto) {
        Address address = addressMapper.addressDto2Address(addressDto);
        return new ResponseSuccess<>(HttpStatus.OK.value(),
                "address added successfully",
                addressService.save(address));
    }

    @PutMapping("/{id}")
    public ResponseSuccess<?> updateAddress(@PathVariable Long id ,@RequestBody @Valid AddressDto addressDto) {
        Address address = addressMapper.addressDto2Address(addressDto);
        address.setId(id);
        return new ResponseSuccess<>(HttpStatus.OK.value(),
                "address updated successfully",
                addressService.save(address));
    }

    @DeleteMapping("/{id}")
    public ResponseSuccess<?> deleteAddress(@PathVariable Long id) {
        addressService.delete(id);
        return new ResponseSuccess<>(HttpStatus.NO_CONTENT.value(),
                "delete address with id" + id);
    }

    @PatchMapping("/{id}")
    public ResponseSuccess<?> patchAddress(@PathVariable Long id, @RequestBody @Valid Map<String, ?> data) {
        return new ResponseSuccess<>(
                HttpStatus.OK.value(),
                "address updated successfully",
                addressService.updatePatch(id, data)
        );
    }
}
