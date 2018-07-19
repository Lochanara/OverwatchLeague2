package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Player;

//@RepositoryRestResource(collectionResourceRel = "league", path = "league")
public interface PlayerRepository extends MongoRepository<Player,Integer> {
	
	Iterable<Player> findAllByOrderByEliminations ();
	Iterable<Player> findAllByOrderByDeaths ();
	Iterable<Player> findAllByOrderByDamage();
	Iterable<Player> findAllByOrderByHealing ();
	Iterable<Player> findAllByOrderByUltimates ();
	Iterable<Player> findAllByOrderByFinalBlows ();
	Iterable<Player> findAllByOrderByTimePlayed ();
	Iterable<Player> findAllByOrderByRole ();
	
	
	Iterable<Player> findByName(String name);
	Iterable<Player> findByTeam(String team);
	Iterable<Player> findByRole(String role);
	
	Iterable<Player> findByTeamOrderByName (String team);
	Iterable<Player> findByTeamOrderByRole (String team);
	Iterable<Player> findByTeamOrderByEliminations (String team);
	Iterable<Player> findByTeamOrderByDeaths (String team);
	Iterable<Player> findByTeamOrderByDamage(String team);
	Iterable<Player> findByTeamOrderByHealing (String team);
	Iterable<Player> findByTeamOrderByUltimates (String team);
	Iterable<Player> findByTeamOrderByFinalBlows (String team);
	Iterable<Player> findByTeamOrderByTimePlayed (String team);
	
	Iterable<Player> findByRoleOrderByName (String role);
	Iterable<Player> findByRoleOrderByTeam (String role);
	Iterable<Player> findByRoleOrderByEliminations (String role);
	Iterable<Player> findByRoleOrderByDeaths (String role);
	Iterable<Player> findByRoleOrderByDamage(String role);
	Iterable<Player> findByRoleOrderByHealing (String role);
	Iterable<Player> findByRoleOrderByUltimates (String role);
	Iterable<Player> findByRoleOrderByFinalBlows (String role);
	Iterable<Player> findByRoleOrderByTimePlayed (String role);

}
