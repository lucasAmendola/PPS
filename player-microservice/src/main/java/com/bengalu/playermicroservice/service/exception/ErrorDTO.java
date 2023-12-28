package com.bengalu.playermicroservice.service.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorDTO {
    private final String message;
}