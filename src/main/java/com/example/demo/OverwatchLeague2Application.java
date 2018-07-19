package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.example.demo.overwatchapi.Data;
import com.example.demo.repositories.PlayerRepository;
import com.example.demo.overwatchapi.PlayerData;
import com.example.demo.models.Player;

@SpringBootApplication
public class OverwatchLeague2Application implements CommandLineRunner {
	
	@Autowired
	PlayerRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(OverwatchLeague2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
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
		
	}
}
