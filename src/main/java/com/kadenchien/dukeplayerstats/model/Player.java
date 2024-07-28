package com.kadenchien.dukeplayerstats.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "player_stats")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer year;
    
    private String season;
    
    private Integer ranker;
    
    private String player;
    
    private Integer games;
    
    @Column(name = "games_started")
    private Integer gamesStarted;
    
    @Column(name = "mp_per_g")
    private Double mpPerG; 
    
    @Column(name = "fg_per_g")
    private Double fgPerG;
    
    @Column(name = "fga_per_g")
    private Double fgaPerG;
    
    @Column(name = "fg_pct")
    private Double fgPct;
    
    @Column(name = "fg2_per_g")
    private Double fg2PerG;
    
    @Column(name = "fg2a_per_g")
    private Double fg2aPerG; 
    
    @Column(name = "fg2_pct")
    private Double fg2Pct;
    
    @Column(name = "fg3_per_g")
    private Double fg3PerG;
    
    @Column(name = "fg3a_per_g")
    private Double fg3aPerG; 
    
    @Column(name = "fg3_pct")
    private Double fg3Pct;
    
    @Column(name = "ft_per_g")
    private Double ftPerG;
    
    @Column(name = "fta_per_g")
    private Double ftaPerG; 
    
    @Column(name = "ft_pct")
    private Double ftPct;
    
    @Column(name = "orb_per_g")
    private Double orbPerG;
    
    @Column(name = "drb_per_g")
    private Double drbPerG;
    
    @Column(name = "trb_per_g")
    private Double trbPerG;
    
    @Column(name = "ast_per_g")
    private Double astPerG;
    
    @Column(name = "stl_per_g")
    private Double stlPerG;
    
    @Column(name = "blk_per_g")
    private Double blkPerG;
    
    @Column(name = "tov_per_g")
    private Double tovPerG;
    
    @Column(name = "pf_per_g")
    private Double pfPerG;
    
    @Column(name = "pts_per_g")
    private Double ptsPerG;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Integer getRanker() {
        return ranker;
    }

    public void setRanker(Integer ranker) {
        this.ranker = ranker;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(Integer gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public Double getMpPerG() {
        return mpPerG;
    }

    public void setMpPerG(Double mpPerG) {
        this.mpPerG = mpPerG;
    }

    public Double getFgPerG() {
        return fgPerG;
    }

    public void setFgPerG(Double fgPerG) {
        this.fgPerG = fgPerG;
    }

    public Double getFgaPerG() {
        return fgaPerG;
    }

    public void setFgaPerG(Double fgaPerG) {
        this.fgaPerG = fgaPerG;
    }

    public Double getFgPct() {
        return fgPct;
    }

    public void setFgPct(Double fgPct) {
        this.fgPct = fgPct;
    }

    public Double getFg2PerG() {
        return fg2PerG;
    }

    public void setFg2PerG(Double fg2PerG) {
        this.fg2PerG = fg2PerG;
    }

    public Double getFg2aPerG() {
        return fg2aPerG;
    }

    public void setFg2aPerG(Double fg2aPerG) {
        this.fg2aPerG = fg2aPerG;
    }

    public Double getFg2Pct() {
        return fg2Pct;
    }

    public void setFg2Pct(Double fg2Pct) {
        this.fg2Pct = fg2Pct;
    }

    public Double getFg3PerG() {
        return fg3PerG;
    }

    public void setFg3PerG(Double fg3PerG) {
        this.fg3PerG = fg3PerG;
    }

    public Double getFg3aPerG() {
        return fg3aPerG;
    }

    public void setFg3aPerG(Double fg3aPerG) {
        this.fg3aPerG = fg3aPerG;
    }

    public Double getFg3Pct() {
        return fg3Pct;
    }

    public void setFg3Pct(Double fg3Pct) {
        this.fg3Pct = fg3Pct;
    }

    public Double getFtPerG() {
        return ftPerG;
    }

    public void setFtPerG(Double ftPerG) {
        this.ftPerG = ftPerG;
    }

    public Double getFtaPerG() {
        return ftaPerG;
    }

    public void setFtaPerG(Double ftaPerG) {
        this.ftaPerG = ftaPerG;
    }

    public Double getFtPct() {
        return ftPct;
    }

    public void setFtPct(Double ftPct) {
        this.ftPct = ftPct;
    }

    public Double getOrbPerG() {
        return orbPerG;
    }

    public void setOrbPerG(Double orbPerG) {
        this.orbPerG = orbPerG;
    }

    public Double getDrbPerG() {
        return drbPerG;
    }

    public void setDrbPerG(Double drbPerG) {
        this.drbPerG = drbPerG;
    }

    public Double getTrbPerG() {
        return trbPerG;
    }

    public void setTrbPerG(Double trbPerG) {
        this.trbPerG = trbPerG;
    }

    public Double getAstPerG() {
        return astPerG;
    }

    public void setAstPerG(Double astPerG) {
        this.astPerG = astPerG;
    }

    public Double getStlPerG() {
        return stlPerG;
    }

    public void setStlPerG(Double stlPerG) {
        this.stlPerG = stlPerG;
    }

    public Double getBlkPerG() {
        return blkPerG;
    }

    public void setBlkPerG(Double blkPerG) {
        this.blkPerG = blkPerG;
    }

    public Double getTovPerG() {
        return tovPerG;
    }

    public void setTovPerG(Double tovPerG) {
        this.tovPerG = tovPerG;
    }

    public Double getPfPerG() {
        return pfPerG;
    }

    public void setPfPerG(Double pfPerG) {
        this.pfPerG = pfPerG;
    }

    public Double getPtsPerG() {
        return ptsPerG;
    }

    public void setPtsPerG(Double ptsPerG) {
        this.ptsPerG = ptsPerG;
    }
}
