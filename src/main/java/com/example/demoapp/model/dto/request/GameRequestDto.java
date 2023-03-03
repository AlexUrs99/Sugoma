package com.example.demoapp.model.dto.request;

import lombok.Data;

@Data
public class GameRequestDto {
    private String name;
    private int stock;
    private double price;
    private String publisher;
}
