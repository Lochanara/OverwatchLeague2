package com.example.demo.overwatchapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerData {
	
	private Integer playerId;
	private Integer teamId;
	private String role;
	private String name;
	private String team;
	private Double eliminations_avg_per_10m;
	private Double deaths_avg_per_10m;
	private Double hero_damage_avg_per_10m;
	private Double healing_avg_per_10m;
	private Double ultimates_earned_avg_per_10m;
	private Double final_blows_avg_per_10m;
	private Double time_played_total;

	public Integer getPlayerId() {
		return playerId;
	}



	public Integer getTeamId() {
		return teamId;
	}



	public String getRole() {
		return role;
	}



	public String getName() {
		return name;
	}



	public String getTeam() {
		return team;
	}



	public Double getEliminations_avg_per_10m() {
		return eliminations_avg_per_10m;
	}



	public Double getDeaths_avg_per_10m() {
		return deaths_avg_per_10m;
	}



	public Double getHero_damage_avg_per_10m() {
		return hero_damage_avg_per_10m;
	}



	public Double getHealing_avg_per_10m() {
		return healing_avg_per_10m;
	}



	public Double getUltimates_earned_avg_per_10m() {
		return ultimates_earned_avg_per_10m;
	}



	public Double getFinal_blows_avg_per_10m() {
		return final_blows_avg_per_10m;
	}



	public Double getTime_played_total() {
		return time_played_total;
	}



	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}



	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setTeam(String team) {
		this.team = team;
	}



	public void setEliminations_avg_per_10m(Double eliminations_avg_per_10m) {
		this.eliminations_avg_per_10m = eliminations_avg_per_10m;
	}



	public void setDeaths_avg_per_10m(Double deaths_avg_per_10m) {
		this.deaths_avg_per_10m = deaths_avg_per_10m;
	}



	public void setHero_damage_avg_per_10m(Double hero_damage_avg_per_10m) {
		this.hero_damage_avg_per_10m = hero_damage_avg_per_10m;
	}



	public void setHealing_avg_per_10m(Double healing_avg_per_10m) {
		this.healing_avg_per_10m = healing_avg_per_10m;
	}



	public void setUltimates_earned_avg_per_10m(Double ultimates_earned_avg_per_10m) {
		this.ultimates_earned_avg_per_10m = ultimates_earned_avg_per_10m;
	}



	public void setFinal_blows_avg_per_10m(Double final_blows_avg_per_10m) {
		this.final_blows_avg_per_10m = final_blows_avg_per_10m;
	}



	public void setTime_played_total(Double time_played_total) {
		this.time_played_total = time_played_total;
	}

	@Override
    public String toString() {
       // return "Quote{" + "type='" + type + '\'' + ", value=" + value + '}';
		return "";
    }
}
