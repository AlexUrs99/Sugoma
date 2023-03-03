package com.example.demoapp.model.dto.request;

import lombok.Data;

@Data
public class UpdateStockForGamesRequestDto {
    private String game;
    private int quantity;
}
