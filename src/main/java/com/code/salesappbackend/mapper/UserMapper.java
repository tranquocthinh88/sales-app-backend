package com.code.salesappbackend.mapper;

import com.code.salesappbackend.dtos.requests.UserDto;
import com.code.salesappbackend.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final AddressMapper addressMapper;

    public User userDto2User(UserDto userDto) {
        return User.builder()
                .name(userDto.getName())
                .address(addressMapper.addressDto2Address(userDto.getAddress()))
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .role(userDto.getRole())
                .gender(userDto.getGender())
                .dateOfBirth(userDto.getDateOfBirth())
                .build();
    }
}
