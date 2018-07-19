package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Player;
import com.example.demo.overwatchapi.Data;
import com.example.demo.overwatchapi.PlayerData;
import com.example.demo.repositories.PlayerRepository;

@RestController
public class PlayerController {
	
	@Autowired
	PlayerRepository repo;
	
	@GetMapping("/update")
	public String updatePlayers () {
		
		RestTemplate restTemplate = new RestTemplate();
        Data d = restTemplate.getForObject("https://api.overwatchleague.com/stats/players", Data.class);
       
        //s.updateRepo(d.getData());
        
        for (PlayerData m : d.getData()) {
			
			repo.save(new Player(
					m.getPlayerId(),
					m.getTeamId(),
					m.getRole(),
					m.getName(),
					m.getTeam(),
					//heroes,
					String.valueOf(m.getEliminations_avg_per_10m()),
					String.valueOf(m.getDeaths_avg_per_10m()),
					String.valueOf(m.getHero_damage_avg_per_10m()),
					String.valueOf(m.getHealing_avg_per_10m()),
					String.valueOf(m.getUltimates_earned_avg_per_10m()),
					String.valueOf(m.getFinal_blows_avg_per_10m()),
					String.valueOf(m.getTime_played_total())
					));
			
		}
		
        return "Success";
		
	}
	
	@GetMapping("/players")
	public Iterable<Player> getPlayers () {
		
		return repo.findAll();
				
	}
	
	@GetMapping("/players/order/{criteria}")
	public Iterable<Player> getAllPlayersByCriteria (@PathVariable String criteria) {
		
		switch (criteria) {
		
			case "eliminations" :return repo.findAllOrderByEliminations();
			case "deaths" : return repo.findAllOrderByDeaths();
			case "damage" :return repo.findAllOrderByDamage();
			case "healing" :return repo.findAllOrderByHealing();
			case "ultimates" :return repo.findAllOrderByUltimates();
			case "finalblows" :return repo.findAllOrderByFinalBlows();
			case "timeplayed" :return repo.findAllOrderByTimePlayed();
			case "roles" :return repo.findAllOrderByRole();
			default : return null;
		
		}
				
	}
	
	@GetMapping("/players/{criteria}/{criteriaval}")
	public Iterable<Player> getPlayersByCriteria (@PathVariable String criteria, @PathVariable String criteriaval) {
		
		switch (criteria) {
		
		case "name": return repo.findByName(criteriaval);
		case "role": return repo.findByRole(criteriaval);
		case "team": return repo.findByTeam(criteriaval);
		default: return null;
		
		}
				
	}
	
	@GetMapping("/players/{criteria1}/{criteria1val}/order/{criteria2}")
	public Iterable<Player> getPlayerByCriteriaOrderByCriteriaVal (@PathVariable String criteria1, @PathVariable String criteria1val, @PathVariable String criteria2) {
		
		switch (criteria1) {
		
			case "team": switch (criteria2) {
			
						case "name": return repo.findByTeamOrderByName(criteria1val);
						case "role": return repo.findByTeamOrderByRole(criteria1val);
						case "eliminations": return repo.findByTeamOrderByEliminations(criteria1val);
						case "deaths": return repo.findByTeamOrderByDeaths(criteria1val);
						case "damage": return repo.findByTeamOrderByDamage(criteria1val);
						case "healing": return repo.findByTeamOrderByHealing(criteria1val);
						case "ultimates": return repo.findByTeamOrderByUltimates(criteria1val);
						case "finalblows": return repo.findByTeamOrderByFinalBlows(criteria1val);
						case "timeplayed": return repo.findByTeamOrderByTimePlayed(criteria1val);
						default: return null;
			
						}
			
			case "role": switch (criteria2) {
			
						case "name": return repo.findByRoleOrderByName(criteria1val);
						case "team": return repo.findByRoleOrderByTeam(criteria1val);
						case "eliminations": return repo.findByRoleOrderByEliminations(criteria1val);
						case "deaths": return repo.findByRoleOrderByDeaths(criteria1val);
						case "damage": return repo.findByRoleOrderByDamage(criteria1val);
						case "healing": return repo.findByRoleOrderByHealing(criteria1val);
						case "ultimates": return repo.findByRoleOrderByUltimates(criteria1val);
						case "finalblows": return repo.findByRoleOrderByFinalBlows(criteria1val);
						case "timeplayed": return repo.findByRoleOrderByTimePlayed(criteria1val);
						default: return null;
							
						}
			
			default : return null;
	
		}
		
	}
	
}
