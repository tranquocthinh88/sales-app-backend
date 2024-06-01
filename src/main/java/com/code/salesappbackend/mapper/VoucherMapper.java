package com.code.salesappbackend.mapper;

import com.code.salesappbackend.dtos.requests.VoucherDto;
import com.code.salesappbackend.models.Voucher;
import org.springframework.stereotype.Component;

@Component
public class VoucherMapper {
    public Voucher voucherDto2voucher(VoucherDto voucherDto) {
        return Voucher.builder()
                .maxPrice(voucherDto.getMaxPrice())
                .minAmount(voucherDto.getMinAmount())
                .discount(voucherDto.getDiscount())
                .expiredDate(voucherDto.getExpiredDate())
                .voucherType(voucherDto.getVoucherType())
                .quantity(voucherDto.getQuantity())
                .build();
    }
}
