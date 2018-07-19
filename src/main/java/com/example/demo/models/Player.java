package com.example.demo.models;

import org.springframework.data.annotation.Id;

public class Player {
	
	//@Id
	//public String Id;
	@Id
	public int playerId;
	
	public int teamId;
	public String role;
	public String name;
	public String team;
	//public List<String> heroes;
	public Double eliminations;
	public Double deaths;
	public Double damage;
	public Double healing;
	public Double ultimates;
	public Double finalBlows;
	public Double timePlayed;
	
	public Player () {}
	
	public Player (int playerId, int teamId, String role, String name, String team, /**List<String> heroes,**/ Double eliminations, Double deaths, Double damage, Double healing, Double ultimates, Double finalBlows, Double timePlayed) {
		
		this.playerId = playerId;
		this.teamId = teamId;
		this.role = role;
		this.name = name;
		this.team = team;
		//this.heroes = heroes;
		this.eliminations = eliminations;
		this.deaths = deaths;
		this.damage = damage;
		this.healing = healing;
		this.ultimates = ultimates;
		this.finalBlows = finalBlows;
		this.timePlayed = timePlayed;
	
	}
	
	@Override
	public String toString () {
		
		return "";
		
		
	}
	
}
