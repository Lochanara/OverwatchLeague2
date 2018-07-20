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
import com.example.demo.services.PlayerExtended;
import com.example.demo.services.PlayerService;

@RestController
public class PlayerController {
	
	@Autowired
	PlayerRepository repo;
	
	@Autowired
	PlayerService service;
	
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
					m.getEliminations_avg_per_10m(),
					m.getDeaths_avg_per_10m(),
					m.getHero_damage_avg_per_10m(),
					m.getHealing_avg_per_10m(),
					m.getUltimates_earned_avg_per_10m(),
					m.getFinal_blows_avg_per_10m(),
					m.getTime_played_total()
					));
			
		}
		
        return "Success!!";
		
	}
	
	@GetMapping("/players")
	public Iterable<Player> getPlayers () {
		
		return repo.findAll();
				
	}
	
	@GetMapping("/players/order/{criteria}")
	public Iterable<Player> getAllPlayersByCriteria (@PathVariable String criteria) {
		
		switch (criteria) {
		
		    case "team"  :return repo.findAllByOrderByTeam();
			case "roles" :return repo.findAllByOrderByRole();
			case "eliminations" :return repo.findAllByOrderByEliminationsDesc();
			case "deaths" : return repo.findAllByOrderByDeathsDesc();
			case "damage" :return repo.findAllByOrderByDamageDesc();
			case "healing" :return repo.findAllByOrderByHealingDesc();
			case "ultimates" :return repo.findAllByOrderByUltimatesDesc();
			case "finalblows" :return repo.findAllByOrderByFinalBlowsDesc();
			case "timeplayed" :return repo.findAllByOrderByTimePlayedDesc();
			default : return null;
		
		}
				
	}
	
	@GetMapping("/playersext/order/{criteria}")
	public Iterable<PlayerExtended> getAllPlayersextByCriteria (@PathVariable String criteria) {
		
		switch (criteria) {
		
		    case "team"  :return service.findByCriteria("team",repo.findAllByOrderByTeam());
			case "role" :return service.findByCriteria("role",repo.findAllByOrderByRole());
			case "eliminations" :service.findByCriteria("eliminations",repo.findAllByOrderByEliminationsDesc());
			case "deaths" : return service.findByCriteria("damage",repo.findAllByOrderByDeathsDesc());
			case "damage" :return service.findByCriteria("damage",repo.findAllByOrderByDamageDesc());
			case "healing" :return service.findByCriteria("healing",repo.findAllByOrderByFinalBlowsDesc());
			case "ultimates" :return service.findByCriteria("ultimates",repo.findAllByOrderByUltimatesDesc());
			case "finalblows" :return service.findByCriteria("finalblows",repo.findAllByOrderByFinalBlowsDesc());
			case "timeplayed" :return service.findByCriteria("timeplayed",repo.findAllByOrderByTimePlayedDesc());
			case "kd" :return service.findByCriteria("kd",repo.findAll());
			case "totaleliminations" :return service.findByCriteria("totaleliminations",repo.findAll());
			case "totaldeaths" :return service.findByCriteria("totaldeaths",repo.findAll());
			case "totaldamage" :return service.findByCriteria("totaldamage",repo.findAll());
			case "totalhealing" :return service.findByCriteria("totalhealing",repo.findAll());
			case "totalultimates" :return service.findByCriteria("totalultimates",repo.findAll());
			case "totalfinalblows" :return service.findByCriteria("totalfinalblows",repo.findAll());
			case "name" :return service.findByCriteria("name",repo.findAll());
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
						case "eliminations": return repo.findByTeamOrderByEliminationsDesc(criteria1val);
						case "deaths": return repo.findByTeamOrderByDeathsDesc(criteria1val);
						case "damage": return repo.findByTeamOrderByDamageDesc(criteria1val);
						case "healing": return repo.findByTeamOrderByHealingDesc(criteria1val);
						case "ultimates": return repo.findByTeamOrderByUltimatesDesc(criteria1val);
						case "finalblows": return repo.findByTeamOrderByFinalBlowsDesc(criteria1val);
						case "timeplayed": return repo.findByTeamOrderByTimePlayedDesc(criteria1val);
						default: return null;
			
						}
			
			case "role": switch (criteria2) {
			
						case "name": return repo.findByRoleOrderByName(criteria1val);
						case "team": return repo.findByRoleOrderByTeam(criteria1val);
						case "eliminations": return repo.findByRoleOrderByEliminationsDesc(criteria1val);
						case "deaths": return repo.findByRoleOrderByDeathsDesc(criteria1val);
						case "damage": return repo.findByRoleOrderByDamageDesc(criteria1val);
						case "healing": return repo.findByRoleOrderByHealingDesc(criteria1val);
						case "ultimates": return repo.findByRoleOrderByUltimatesDesc(criteria1val);
						case "finalblows": return repo.findByRoleOrderByFinalBlowsDesc(criteria1val);
						case "timeplayed": return repo.findByRoleOrderByTimePlayedDesc(criteria1val);
						default: return null;
							
						}
			
			default : return null;
	
		}
		
	}
	
	@GetMapping("/playersext/{criteria1}/{criteria1val}/order/{criteria2}")
	public Iterable<PlayerExtended> getPlayerextByCriteriaOrderByCriteriaVal (@PathVariable String criteria1, @PathVariable String criteria1val, @PathVariable String criteria2) {
		
		switch (criteria1) {
		
			case "team": switch (criteria2) {
			
						case "name": return service.findByCriteria(criteria2,repo.findByTeamOrderByName(criteria1val));
						case "role": return service.findByCriteria(criteria2, repo.findByTeamOrderByRole(criteria1val));
						case "eliminations": return service.findByCriteria(criteria2, repo.findByTeamOrderByEliminationsDesc(criteria1val));
						case "deaths": return service.findByCriteria(criteria2, repo.findByTeamOrderByDeathsDesc(criteria1val));
						case "damage": return service.findByCriteria(criteria2, repo.findByTeamOrderByDamageDesc(criteria1val));
						case "healing": return service.findByCriteria(criteria2, repo.findByTeamOrderByHealingDesc(criteria1val));
						case "ultimates": return service.findByCriteria(criteria2, repo.findByTeamOrderByUltimatesDesc(criteria1val));
						case "finalblows": return service.findByCriteria(criteria2, repo.findByTeamOrderByFinalBlowsDesc(criteria1val));
						case "timeplayed": return service.findByCriteria(criteria2, repo.findByTeamOrderByTimePlayedDesc(criteria1val));
						case "totaleliminations": return service.findByCriteria(criteria2, repo.findByTeam(criteria1val));
						case "totaldeaths": return service.findByCriteria(criteria2, repo.findByTeam(criteria1val));
						case "totaldamage": return service.findByCriteria(criteria2, repo.findByTeam(criteria1val));
						case "totalhealing": return service.findByCriteria(criteria2, repo.findByTeam(criteria1val));
						case "totalultimates": return service.findByCriteria(criteria2, repo.findByTeam(criteria1val));
						case "totalfinalblows": return service.findByCriteria(criteria2, repo.findByTeam(criteria1val));
						case "kd": return service.findByCriteria(criteria2, repo.findByTeam(criteria1val));
						default: return null;
			
						}
			
			case "role": switch (criteria2) {
			
						case "name": return service.findByCriteria(criteria2, repo.findByRoleOrderByName(criteria1val));
						case "team": return service.findByCriteria(criteria2, repo.findByRoleOrderByTeam(criteria1val));
						case "eliminations": return service.findByCriteria(criteria2, repo.findByRoleOrderByEliminationsDesc(criteria1val));
						case "deaths": return service.findByCriteria(criteria2, repo.findByRoleOrderByDeathsDesc(criteria1val));
						case "damage": return service.findByCriteria(criteria2, repo.findByRoleOrderByDamageDesc(criteria1val));
						case "healing": return service.findByCriteria(criteria2, repo.findByRoleOrderByHealingDesc(criteria1val));
						case "ultimates": return service.findByCriteria(criteria2, repo.findByRoleOrderByUltimatesDesc(criteria1val));
						case "finalblows": return service.findByCriteria(criteria2, repo.findByRoleOrderByFinalBlowsDesc(criteria1val));
						case "timeplayed": return service.findByCriteria(criteria2, repo.findByRoleOrderByTimePlayedDesc(criteria1val));
						case "totaleliminations": return service.findByCriteria(criteria2, repo.findByRole(criteria1val));
						case "totaldeaths": return service.findByCriteria(criteria2, repo.findByRole(criteria1val));
						case "totaldamage": return service.findByCriteria(criteria2, repo.findByRole(criteria1val));
						case "totalhealing": return service.findByCriteria(criteria2, repo.findByRole(criteria1val));
						case "totalultimates": return service.findByCriteria(criteria2, repo.findByRole(criteria1val));
						case "totalfinalblows": return service.findByCriteria(criteria2, repo.findByRole(criteria1val));
						case "kd": return service.findByCriteria(criteria2, repo.findByRole(criteria1val));
						default: return null;
							
						}
			
			default : return null;
	
		}
		
	}
	
}
