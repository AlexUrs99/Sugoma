package com.example.demoapp.service.contract;

import com.example.demoapp.model.dto.response.GameResponseDto;

import java.util.List;

public interface GameService {

    List<GameResponseDto> getAllGames();

    void updateStocks(StockUpdateRequest stockUpdateRequest);
}
