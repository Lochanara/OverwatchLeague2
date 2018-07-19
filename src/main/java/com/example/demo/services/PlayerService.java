package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.models.Player;
import com.example.demo.repositories.PlayerRepository;

@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository repo;
		
	public Iterable<PlayerKD> findAllByKD () {
		
		List<PlayerKD> playerKD = new ArrayList<PlayerKD>();
		
		List<Player> players = repo.findAll(); 
		
		for (Player p : players) {
			
			playerKD.add(new PlayerKD(p.name,p.eliminations/p.deaths, p.playerId, p.teamId, p.role, p.team, p.eliminations, p.deaths, p.damage, p.healing, p.ultimates, p.finalBlows, p.timePlayed));
			
		}
		
		Collections.sort(playerKD, new Comparator<PlayerKD>() {
			
			@Override
		    public int compare(PlayerKD o1, PlayerKD o2) {
		        return (Double.compare(o2.KD, o1.KD));
		    }
						
		});
		
		return playerKD;
		
	}
	
	public Iterable<PlayerExtended> findByCriteria (String criteria) {
		
		List<PlayerExtended> playerExtended = new ArrayList<PlayerExtended>();
		
		List<Player> players = repo.findAll();
		
		for (Player p : players) {
			
			playerExtended.add(new PlayerExtended(p.name,p.eliminations/p.deaths, p.timePlayed/10*p.eliminations, p.timePlayed/10*p.deaths, p.timePlayed/10*p.damage, p.timePlayed/10*p.healing, p.timePlayed/10*p.ultimates, p.timePlayed/10*p.finalBlows, p.playerId, p.teamId, p.role, p.team, p.eliminations, p.deaths, p.damage, p.healing, p.ultimates, p.finalBlows, p.timePlayed));
			
		}
		
		switch(criteria) {
		
			case "kd": Collections.sort(playerExtended, new Comparator<PlayerExtended>() {
				
				@Override
			    public int compare(PlayerExtended o1, PlayerExtended o2) {
			        return (Double.compare(o2.KD, o1.KD));
			    }
							
			});
			break;
				
			case "totalEliminations":Collections.sort(playerExtended, new Comparator<PlayerExtended>() {
				
				@Override
			    public int compare(PlayerExtended o1, PlayerExtended o2) {
			        return (Double.compare(o2.totalEliminations, o1.totalEliminations));
			    }
							
			});
			break;
		
			case "totalDeaths":Collections.sort(playerExtended, new Comparator<PlayerExtended>() {
				
				@Override
			    public int compare(PlayerExtended o1, PlayerExtended o2) {
			        return (Double.compare(o2.totalDeaths, o1.totalDeaths));
			    }
							
			});
			break;
				
			case "totalDamage":Collections.sort(playerExtended, new Comparator<PlayerExtended>() {
				
				@Override
			    public int compare(PlayerExtended o1, PlayerExtended o2) {
			        return (Double.compare(o2.totalDamage, o1.totalDamage));
			    }
							
			});
			break;
				
			case "totalHealing":Collections.sort(playerExtended, new Comparator<PlayerExtended>() {
				
				@Override
			    public int compare(PlayerExtended o1, PlayerExtended o2) {
			        return (Double.compare(o2.totalHealing, o1.totalHealing));
			    }
							
			});
			break;
				
			case "totalUltimates":Collections.sort(playerExtended, new Comparator<PlayerExtended>() {
				
				@Override
			    public int compare(PlayerExtended o1, PlayerExtended o2) {
			        return (Double.compare(o2.totalUltimates, o1.totalUltimates));
			    }
							
			});
			break;
				
			case "totalFinalBlows":Collections.sort(playerExtended, new Comparator<PlayerExtended>() {
				
				@Override
			    public int compare(PlayerExtended o1, PlayerExtended o2) {
			        return (Double.compare(o2.totalFinalBlows, o1.totalFinalBlows));
			    }
							
			});
			break;
				
			default : break;

		}
		
		return playerExtended;
		
	}

}
