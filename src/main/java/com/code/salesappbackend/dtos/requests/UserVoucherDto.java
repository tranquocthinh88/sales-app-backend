package com.code.salesappbackend.dtos.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class UserVoucherDto {
    @NotNull(message = "user id must be not null")
    private Long userId;
    @NotNull(message = "voucher id must be not null")
    private Long voucherId;
    private boolean isUsed;

}
