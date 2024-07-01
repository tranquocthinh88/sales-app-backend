package com.code.salesappbackend.mapper;

import com.code.salesappbackend.dtos.requests.ProviderDto;
import com.code.salesappbackend.models.Provider;
import com.code.salesappbackend.models.enums.Status;
import com.code.salesappbackend.services.interfaces.ProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProviderMapper {
    private final AddressMapper addressMapper;
    private final ProviderService providerService;

    public Provider providerDto2Provider(ProviderDto providerDto) throws Exception {
        providerService.checkExistsProviderName(providerDto.getProviderName());
        Provider provider = new Provider();
        provider.setProviderName(providerDto.getProviderName());
        provider.setAddress(addressMapper.addressDto2Address(providerDto.getAddress()));
        provider.setEmail(providerDto.getEmail());
        provider.setPhoneNumber(providerDto.getPhoneNumber());
        provider.setStatus(Status.ACTIVE);
        return provider;
    }
}
