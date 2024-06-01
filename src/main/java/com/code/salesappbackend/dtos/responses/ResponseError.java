package com.code.salesappbackend.dtos.responses;

import java.util.List;

public record ResponseError(int status, List<String> errors) {
}
