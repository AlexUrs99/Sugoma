package com.example.demoapp.controller;

import com.example.demoapp.model.dto.request.UpdateStockForGamesRequestDto;
import com.example.demoapp.service.contract.GameService;
import com.example.demoapp.service.contract.StockUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/manevra")
@RequiredArgsConstructor
public class ControllerManevra {

    private final GameService gameService;

    @PostMapping("/test")
    public void test(@RequestBody StockUpdateRequest request) {
        gameService.updateStocks(request);
    }
}
