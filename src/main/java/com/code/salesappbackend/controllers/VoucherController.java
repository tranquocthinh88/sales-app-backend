package com.code.salesappbackend.controllers;

import com.code.salesappbackend.dtos.requests.VoucherDto;
import com.code.salesappbackend.dtos.responses.ResponseSuccess;
import com.code.salesappbackend.mapper.VoucherMapper;
import com.code.salesappbackend.models.Voucher;
import com.code.salesappbackend.services.interfaces.VoucherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vouchers")
@RequiredArgsConstructor
public class VoucherController {

    private final VoucherService voucherService;
    private final VoucherMapper voucherMapper;

    @PostMapping
    public ResponseSuccess<?> addVoucher(@RequestBody @Valid VoucherDto voucherDto) {
        Voucher voucher = voucherMapper.voucherDto2voucher(voucherDto);
        return new ResponseSuccess<>(HttpStatus.OK.value(),
                "add voucher successfully",
                voucherService.save(voucher));
    }
}
