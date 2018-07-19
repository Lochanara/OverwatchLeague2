package com.example.demo.services;

public class PlayerKD {
	
	public String name;
	public Double KD;
	
	public int playerId;
	public int teamId;
	public String role;
	public String team;
	public Double eliminations;
	public Double deaths;
	public Double damage;
	public Double healing;
	public Double ultimates;
	public Double finalBlows;
	public Double timePlayed;
	
	public PlayerKD (String name, Double KD,int playerId,int teamId,String role,String team,Double eliminations,Double deaths,Double damage,Double healing,Double ultimates,Double finalBlows,Double timePlayed) {
		
		this.name = name;
		this.KD =KD;
		this.playerId = playerId;
		this.role = role;
		this.team = team;
		this.eliminations = eliminations;
		this.deaths = deaths;
		this.damage = damage;
		this.healing = healing;
		this.ultimates = ultimates;
		this.finalBlows =finalBlows;
		this.timePlayed = timePlayed;
		
		
	}

}
