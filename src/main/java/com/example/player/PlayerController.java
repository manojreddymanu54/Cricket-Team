package com.example.player;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.player.Player;
import com.example.player.PlayerRepository;
import com.example.player.PlayerService;

@RestController
public class PlayerController {
    PlayerService service = new PlayerService();

    @GetMapping("/players")
    public ArrayList<Player> getplayersdetails() {
        return service.getplayersdetails();
    }

    @GetMapping("/players/{playerId}")
    public Player getplayerdetails(@PathVariable("playerId") int playerId) {

        return service.getplayerdetails(playerId);

    }

    @PostMapping("/players")
    public Player addplayer(@RequestBody Player player) {
        return service.addplayer(player);
    }

    @PutMapping("/players/{playerId}")
    public Player updateplayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {
        return service.updateplayer(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")

    public void deleteplayer(@PathVariable("playerId") int playerId) {
        service.deleteplayer(playerId);
    }

}