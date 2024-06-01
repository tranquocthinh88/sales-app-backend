package com.code.salesappbackend.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class UserVoucherDto {
    private Long userId;
    private Long voucherId;
    private boolean isUsed;

}
