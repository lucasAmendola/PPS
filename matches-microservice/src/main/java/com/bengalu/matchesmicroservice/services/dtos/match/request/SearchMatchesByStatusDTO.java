package com.bengalu.matchesmicroservice.services.dtos.match.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchMatchesByStatusDTO {

    private String status;
}
