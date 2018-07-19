package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Player;

//@RepositoryRestResource(collectionResourceRel = "league", path = "league")
public interface PlayerRepository extends MongoRepository<Player,Integer> {
	
	Iterable<Player> findAllByOrderByTeam ();
	Iterable<Player> findAllByOrderByRole ();
	Iterable<Player> findAllByOrderByEliminationsDesc ();
	Iterable<Player> findAllByOrderByDeathsDesc ();
	Iterable<Player> findAllByOrderByDamageDesc();
	Iterable<Player> findAllByOrderByHealingDesc ();
	Iterable<Player> findAllByOrderByUltimatesDesc ();
	Iterable<Player> findAllByOrderByFinalBlowsDesc ();
	Iterable<Player> findAllByOrderByTimePlayedDesc ();	
		
	Iterable<Player> findByName(String name);
	Iterable<Player> findByTeam(String team);
	Iterable<Player> findByRole(String role);
	
	Iterable<Player> findByTeamOrderByName (String team);
	Iterable<Player> findByTeamOrderByRole (String team);
	Iterable<Player> findByTeamOrderByEliminationsDesc (String team);
	Iterable<Player> findByTeamOrderByDeathsDesc (String team);
	Iterable<Player> findByTeamOrderByDamageDesc(String team);
	Iterable<Player> findByTeamOrderByHealingDesc (String team);
	Iterable<Player> findByTeamOrderByUltimatesDesc (String team);
	Iterable<Player> findByTeamOrderByFinalBlowsDesc (String team);
	Iterable<Player> findByTeamOrderByTimePlayedDesc (String team);
	
	Iterable<Player> findByRoleOrderByName (String role);
	Iterable<Player> findByRoleOrderByTeam (String role);
	Iterable<Player> findByRoleOrderByEliminationsDesc (String role);
	Iterable<Player> findByRoleOrderByDeathsDesc (String role);
	Iterable<Player> findByRoleOrderByDamageDesc(String role);
	Iterable<Player> findByRoleOrderByHealingDesc (String role);
	Iterable<Player> findByRoleOrderByUltimatesDesc (String role);
	Iterable<Player> findByRoleOrderByFinalBlowsDesc (String role);
	Iterable<Player> findByRoleOrderByTimePlayedDesc (String role);

}
