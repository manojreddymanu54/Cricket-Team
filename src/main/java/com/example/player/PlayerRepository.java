package com.example.player;

import java.util.*;

import com.example.player.Player;

public interface PlayerRepository {
    ArrayList<Player> getplayersdetails();

    Player getplayerdetails(int playerId);

    Player addplayer(Player player);

    Player updateplayer(int playerId, Player player);

    void deleteplayer(int playerId);
}
