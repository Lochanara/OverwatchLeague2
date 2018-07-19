package com.example.demo.services;

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
		
		List<PlayerKD> playerKD = null;
		
		List<Player> players = repo.findAll(); 
		
		for (Player p : players) {
			
			playerKD.add(new PlayerKD(p.name,p.eliminations/p.deaths));
			
		}
		
		return playerKD;
		
	}

}
