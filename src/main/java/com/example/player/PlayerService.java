package com.example.player;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.player.Player;
import com.example.player.PlayerRepository;
import java.util.*;
// Don't modify the below code

public class PlayerService implements PlayerRepository {

    private static HashMap<Integer, Player> team = new HashMap<>();
    private int uniqueId = 12;

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    @Override
    public ArrayList<Player> getplayersdetails() {
        Collection<Player> playerscollection = team.values();
        ArrayList<Player> playersdetails = new ArrayList<>(playerscollection);
        return playersdetails;

    }

    @Override
    public Player getplayerdetails(int playerId) {
        Player details = team.get(playerId);
        if (details == null) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return details;
    }

    @Override
    public Player addplayer(Player player) {
        player.setPlayerId(uniqueId);
        team.put(uniqueId, player);
        uniqueId = uniqueId + 1;

        return player;
    }

    @Override
    public Player updateplayer(int playerId, Player player) {
        Player exsist = team.get(playerId);
        if (exsist == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            
        }

        if (player.getPlayerName() != null) {
            exsist.setPlayerName(player.getPlayerName());
        }

        if (player.getRole() != null) {
            exsist.setRole(player.getRole());
        }

        if (player.getJerseyNumber() != 0) {
            exsist.setJerseyNumber(player.getJerseyNumber());
        }

        return exsist;
    }

    @Override
    public void deleteplayer(int playerId) {
        Player play = team.get(playerId);
        if (play == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        else {
            team.remove(playerId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

}
