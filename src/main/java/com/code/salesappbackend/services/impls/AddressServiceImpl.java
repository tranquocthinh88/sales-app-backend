package com.code.salesappbackend.services.impls;

import com.code.salesappbackend.models.Address;
import com.code.salesappbackend.services.interfaces.AddressService;
import com.code.salesappbackend.services.interfaces.BaseService;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl extends BaseServiceImpl<Address, Long> implements AddressService {

    public AddressServiceImpl(BaseService<Address, Long> repository) {
        super(repository, Address.class);
    }
}
