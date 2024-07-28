package com.kadenchien.dukeplayerstats.repository;

import com.kadenchien.dukeplayerstats.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    List<Player> findByPlayer(String player);
    List<Player> findBySeason(String season);
}
