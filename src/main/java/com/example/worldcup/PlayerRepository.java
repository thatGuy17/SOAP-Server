package com.example.worldcup;

import localhost._8080.worldcup.Player;
import localhost._8080.worldcup.Position;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class PlayerRepository {
  private static final Map<String, Player> players = new HashMap<>();
    private static final Map<String, Player> countries = new HashMap<>();

  @PostConstruct
  public void initData() {
      addPlayersToHashMap(new Player(), "Lionel Messi", "Barcelona", "Argentina", "1987", 170, 72, Position.FW);
      addPlayersToHashMap(new Player(), "Eden Hazard", "Chelsea", "Belgium", "1991", 173, 74, Position.FW);
      addPlayersToHashMap(new Player(), "Neymar", "PSG", "Brazil", "1992", 175, 68, Position.FW);
      addPlayersToHashMap(new Player(), "James Rodriguez", "Bayern Munich", "Colombia", "1992", 180, 75, Position.MF);
      addPlayersToHashMap(new Player(), "Luka Modric", "Real Madrid", "Croatia", "1985", 172, 66, Position.MF);
      addPlayersToHashMap(new Player(), "Christian Eriksen", "Tottenham Hotspur", "Denmark", "1992", 181, 76, Position.MF);
      addPlayersToHashMap(new Player(), "Mohamed Salah", "Liverpool", "Egypt", "1992", 175, 71, Position.FW);
      addPlayersToHashMap(new Player(), "Harry Kane", "Tottenham Hotspur", "England", "1993", 188, 98, Position.FW);
      addPlayersToHashMap(new Player(), "Paul Pogba", "Manchester United", "France", "1993", 191, 86, Position.MF);
      addPlayersToHashMap(new Player(), "Toni Kroos", "Real Madrid", "Germany", "1990", 182, 78, Position.MF);
      addPlayersToHashMap(new Player(), "Heung-Min Son", "Tottenham Hotspur", "Korea Republic", "1992", 183, 76, Position.FW);
      addPlayersToHashMap(new Player(), "Sadio Mane", "Liverpool", "Senegal", "1992", 175, 69, Position.FW);
      addPlayersToHashMap(new Player(), "Cristiano Ronaldo", "Real Madrid", "Portugal", "1985", 185, 80, Position.FW);
  }

  private void addPlayersToHashMap(Player player, String s, String s1, String s2, String s3, int i, int i1, Position p) {
      player.setPlayerName(s);
      player.setClubName(s1);
      player.setCountry(s2);
      player.setDateOfBirth(s3);
      player.setHeight(i);
      player.setWeight(i1);
      player.setPosition(p);

      players.put(player.getPlayerName(), player);
      countries.put(player.getCountry(), player);
  }

    public Player findPlayerByName(String name) {
     return players.get(name);
  }

  public Player findPlayerByCountry(String country){
      return countries.get(country);
  }
}
