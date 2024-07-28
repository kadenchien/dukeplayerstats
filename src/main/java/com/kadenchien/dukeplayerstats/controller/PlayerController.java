package com.kadenchien.dukeplayerstats.controller;

import com.kadenchien.dukeplayerstats.model.Player;
import com.kadenchien.dukeplayerstats.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable int id) {
        return playerService.getPlayerById(id)
                .map(player -> ResponseEntity.ok().body(player))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @RequestBody Player playerDetails) {
        return playerService.getPlayerById(id)
                .map(player -> {
                    player.setSeason(playerDetails.getSeason());
                    player.setRanker(playerDetails.getRanker());
                    player.setPlayer(playerDetails.getPlayer());
                    player.setGames(playerDetails.getGames());
                    player.setGamesStarted(playerDetails.getGamesStarted());
                    player.setMpPerG(playerDetails.getMpPerG());
                    player.setFgPerG(playerDetails.getFgPerG());
                    player.setFgaPerG(playerDetails.getFgaPerG());
                    player.setFgPct(playerDetails.getFgPct());
                    player.setFg2PerG(playerDetails.getFg2PerG());
                    player.setFg2aPerG(playerDetails.getFg2aPerG());
                    player.setFg2Pct(playerDetails.getFg2Pct());
                    player.setFg3PerG(playerDetails.getFg3PerG());
                    player.setFg3aPerG(playerDetails.getFg3aPerG());
                    player.setFg3Pct(playerDetails.getFg3Pct());
                    player.setFtPerG(playerDetails.getFtPerG());
                    player.setFtaPerG(playerDetails.getFtaPerG());
                    player.setFtPct(playerDetails.getFtPct());
                    player.setOrbPerG(playerDetails.getOrbPerG());
                    player.setDrbPerG(playerDetails.getDrbPerG());
                    player.setTrbPerG(playerDetails.getTrbPerG());
                    player.setAstPerG(playerDetails.getAstPerG());
                    player.setStlPerG(playerDetails.getStlPerG());
                    player.setBlkPerG(playerDetails.getBlkPerG());
                    player.setTovPerG(playerDetails.getTovPerG());
                    player.setPfPerG(playerDetails.getPfPerG());
                    player.setPtsPerG(playerDetails.getPtsPerG());
                    return ResponseEntity.ok().body(playerService.savePlayer(player));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
        return playerService.getPlayerById(id)
                .map(player -> {
                    playerService.deletePlayer(id);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public List<Player> getPlayersByPlayer(@RequestParam("player") String player) {
        return playerService.getPlayersByPlayer(player);
    }

    @GetMapping("/season")
    public List<Player> getPlayersBySeason(@RequestParam("season") String season) {
        return playerService.getPlayersBySeason(season);
    }
}
