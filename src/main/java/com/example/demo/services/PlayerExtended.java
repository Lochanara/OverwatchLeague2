package com.example.demo.services;

public class PlayerExtended {

	public String name;
	public Double KD;
	public Double totalEliminations;
	public Double totalDeaths;
	public Double totalDamage;
	public Double totalHealing;
	public Double totalUltimates;
	public Double totalFinalBlows;

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
	
	public PlayerExtended (String name, Double KD, Double totalEliminations, Double totalDeaths, Double totalDamage, Double totalHealing, Double totalUltimates, Double totalFinalBlows, int playerId,int teamId,String role,String team,Double eliminations,Double deaths,Double damage,Double healing,Double ultimates,Double finalBlows,Double timePlayed) {
		
		this.name = name;
		this.KD =KD;
		this.totalDamage =totalDamage;
		this.totalDeaths = totalDeaths;
		this.totalEliminations = totalEliminations;
		this.totalFinalBlows = totalFinalBlows;
		this.totalHealing =  totalHealing;
		this.totalUltimates = totalUltimates;
		this.playerId = playerId;
		this.role = role;
		this.team = team;
		this.teamId = teamId;
		this.eliminations = eliminations;
		this.deaths = deaths;
		this.damage = damage;
		this.healing = healing;
		this.ultimates = ultimates;
		this.finalBlows =finalBlows;
		this.timePlayed = timePlayed;
		
		
	}
}
