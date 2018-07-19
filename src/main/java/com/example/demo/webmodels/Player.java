package com.example.demo.webmodels;

public class Player {

	private int playerId;
	private int teamId;
	private String role;
	private String name;
	private String team;
	//public List<String> heroes;
	private String eliminations;
	private String deaths;
	private String damage;
	private String healing;
	private String ultimates;
	private String finalBlows;
	private String timePlayed;
	
	public int getPlayerId() {
		return playerId;
	}
	public int getTeamId() {
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
	public String getEliminations() {
		return eliminations;
	}
	public String getDeaths() {
		return deaths;
	}
	public String getDamage() {
		return damage;
	}
	public String getHealing() {
		return healing;
	}
	public String getUltimates() {
		return ultimates;
	}
	public String getFinalBlows() {
		return finalBlows;
	}
	public String getTimePlayed() {
		return timePlayed;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public void setTeamId(int teamId) {
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
	public void setEliminations(String eliminations) {
		this.eliminations = eliminations;
	}
	public void setDeaths(String deaths) {
		this.deaths = deaths;
	}
	public void setDamage(String damage) {
		this.damage = damage;
	}
	public void setHealing(String healing) {
		this.healing = healing;
	}
	public void setUltimates(String ultimates) {
		this.ultimates = ultimates;
	}
	public void setFinalBlows(String finalBlows) {
		this.finalBlows = finalBlows;
	}
	public void setTimePlayed(String timePlayed) {
		this.timePlayed = timePlayed;
	}

}

