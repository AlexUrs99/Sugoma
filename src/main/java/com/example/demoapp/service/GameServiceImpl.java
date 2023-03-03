package com.example.demoapp.service;

import com.example.demoapp.model.dto.request.UpdateStockForGamesRequestDto;
import com.example.demoapp.model.dto.response.GameResponseDto;
import com.example.demoapp.model.entity.Game;
import com.example.demoapp.repo.GameRepo;
import com.example.demoapp.service.contract.GameService;
import com.example.demoapp.service.contract.StockUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepo gameRepo;

    public List<GameResponseDto> getAllGames() {
        return gameRepo.findAll().stream()
                .map(this::mapToDto)
                .collect(toList());
    }

    @Override
    public void updateStocks(StockUpdateRequest stockUpdateRequest) {
        for (UpdateStockForGamesRequestDto request : stockUpdateRequest.updateStockRequests()) {
            Game game = gameRepo.findByNameIs(request.getGame())
                    .orElseThrow(() -> new RuntimeException("Ba cv nu ii in regula!"));
            game.decreaseStock(request.getQuantity());
            gameRepo.save(game);
        }
    }

    private GameResponseDto mapToDto(Game game) {
        var dto = new GameResponseDto();
        dto.setName(game.getName());
        dto.setPrice(game.getPrice());
        dto.setStock(game.getStock());
        dto.setPublisher(game.getPublisher().getName());
        return dto;
    }

    public GameResponseDto getByName(String name) {
        Optional<Game> foundGame = gameRepo.findByNameIs(name);
        return foundGame
                .map(this::mapToDto)
                .orElseThrow(() -> new RuntimeException("Could not find game"));
    }
}
