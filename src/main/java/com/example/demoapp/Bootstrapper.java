package com.example.demoapp;

import com.example.demoapp.model.entity.Game;
import com.example.demoapp.model.entity.Publisher;
import com.example.demoapp.repo.GameRepo;
import com.example.demoapp.repo.PublisherRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrapper implements ApplicationListener<ApplicationReadyEvent> {

    private final GameRepo gameRepo;
    private final PublisherRepo publisherRepo;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Publisher ubisoft = createUbisoftPublisher();
        Game acGame = createACGame();

        publisherRepo.save(ubisoft);
        acGame.setPublisher(ubisoft);
        gameRepo.save(acGame);
    }

    private Publisher createUbisoftPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("Ubisoft");
        return publisher;
    }

    private Game createACGame() {
        Game ac = new Game();
        ac.setName("AC");
        ac.setStock(5);
        ac.setPrice(5.0);
        return ac;
    }
}
