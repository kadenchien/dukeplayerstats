package com.kadenchien.dukeplayerstats.service;

import com.kadenchien.dukeplayerstats.model.Player;
import com.kadenchien.dukeplayerstats.repository.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(int id) {
        return playerRepository.findById(id);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    public List<Player> getPlayersByPlayer(String player) {
        return playerRepository.findByPlayer(player);
    }

    public List<Player> getPlayersBySeason(String season) {
        return playerRepository.findBySeason(season);
    }
}
