/**
 * 
 */
package com.cotemig.campeonatoFutebol.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cotemig.campeonatoFutebol.model.Equipe;

/**
 * @author equipe devs
 *
 */
@Repository("equipeRepository")
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

	@Query(value = "SELECT * FROM EQUIPE WHERE campeonato_id = ?1", nativeQuery = true)
	List<Equipe> getAllEquipesByCampeonato(Integer idCampeonato);

	@Query(value = "SELECT nome FROM EQUIPE WHERE id = ?1", nativeQuery = true)
	String getNomeEquipe(Integer id);

}
