package com.example.worldcup;

import localhost._8080.worldcup.GetPlayerByNameRequest;
import localhost._8080.worldcup.GetPlayerByNameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PlayerEndpoint {
  private static final String NAMESPACE_URI = "http://localhost:8080/worldcup";

  private PlayerRepository playerRepository;

  @Autowired
  public PlayerEndpoint(PlayerRepository playerRepository) {
     this.playerRepository = playerRepository;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPlayerByNameRequest")
  @ResponsePayload
  public GetPlayerByNameResponse getPlayerByName(@RequestPayload GetPlayerByNameRequest request) {
     GetPlayerByNameResponse response = new GetPlayerByNameResponse();
     response.setPlayer(playerRepository.findPlayerByName(request.getName()));

     return response;
  }
}
