package com.example.demoapp.model.dto.response;

import lombok.Data;

@Data
public class GameResponseDto {
    private String name;
    private int stock;
    private Double price;
    private String publisher;
}
