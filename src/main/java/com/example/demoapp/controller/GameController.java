package com.example.demoapp.controller;

import com.example.demoapp.model.dto.request.GameRequestDto;
import com.example.demoapp.model.dto.response.GameResponseDto;
import com.example.demoapp.service.GameServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/games")
@RequiredArgsConstructor
public class GameController {

    private final GameServiceImpl gameService;

    @GetMapping("/all")
    public List<GameResponseDto> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/find-by-name/{name}")
    public GameResponseDto getGameAtName(@PathVariable String name) {
        return gameService.getByName(name);
    }

    @PostMapping("/create")
    public GameResponseDto createGame(@RequestBody GameRequestDto newGame){
      return   gameService.createGame(newGame);
    }
    @DeleteMapping("/delete/{name}")
    public void deleteGame(@PathVariable String name){
        gameService.deleteGame(name);
    }
    @PutMapping("/update/{id}")
    public GameResponseDto updateGame(@RequestBody GameRequestDto updateGame,@PathVariable Long id){
        return gameService.updateGame(updateGame,id);

    }

}
