package com.code.salesappbackend.mapper;

import com.code.salesappbackend.dtos.requests.SizeDto;
import com.code.salesappbackend.exceptions.DataExistsException;
import com.code.salesappbackend.exceptions.NullDataException;
import com.code.salesappbackend.models.Size;
import com.code.salesappbackend.services.interfaces.SizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SizeMapper {
    private final SizeService sizeService;

    public Size sizeDto2Size(SizeDto sizeDto) throws DataExistsException, NullDataException {
        if(sizeDto.getNumberSize() == null && sizeDto.getTextSize() == null) {
            throw new NullDataException("text or num size must be not null");
        }
        if(sizeDto.getNumberSize() != null) {
            sizeService.existsByNumberSize(sizeDto.getNumberSize());
        }
        if(sizeDto.getTextSize() != null) {
            sizeService.existsByTextSize(sizeDto.getTextSize());
        }
        Size size = new Size();
        size.setNumberSize(sizeDto.getNumberSize());
        size.setTextSize(sizeDto.getTextSize());
        size.setSizeType(sizeDto.getSizeType());
        return size;
    }
}
