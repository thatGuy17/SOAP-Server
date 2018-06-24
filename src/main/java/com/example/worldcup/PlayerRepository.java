package com.example.worldcup;

import localhost._8080.worldcup.Player;
import localhost._8080.worldcup.Position;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class PlayerRepository {
  private static final Map<String, Player> players = new HashMap<>();

  @PostConstruct
  public void initData() {
    Player Messi = new Player();
    Messi.setPlayerName("Lionel Messi");
    Messi.setClubName("Barcelona");
    Messi.setCountry("Argentina");
    Messi.setDateOfBirth("1987");
    Messi.setHeight(170);
    Messi.setWeight(65);
    Messi.setPosition(Position.FW);

    Player Hazard = new Player();
    Hazard.setPlayerName("Eden Hazard");
    Hazard.setClubName("Chelsea");
    Hazard.setCountry("Belgium");
    Hazard.setDateOfBirth("1991");
    Hazard.setHeight(170);
    Hazard.setWeight(75);
    Hazard.setPosition(Position.FW);

    players.put(Hazard.getPlayerName(), Hazard);
  }

  public Player findPlayerByName(String name) {
     Assert.notNull(name, "The players's name must not be null");
     return players.get(name);
  }
}
