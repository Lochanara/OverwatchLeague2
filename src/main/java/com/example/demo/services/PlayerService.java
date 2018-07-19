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

}
