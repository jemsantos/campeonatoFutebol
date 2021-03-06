/**
 * 
 */
package com.cotemig.campeonatoFutebol.service;

import java.util.List;
import java.util.Optional;

import com.cotemig.campeonatoFutebol.model.Jogador;

/**
 * @author equipe devs
 *
 */
public interface JogadorService {
	Optional<Jogador> getJogadorById(Integer id);

	List<Jogador> getAllJogadoresByAge(Integer age);

	List<Jogador> getAllJogadoresByEquipe(Integer idEquipe);

	List<Jogador> getAllJogadores();

	void insertJogador(Jogador jogador);

	void updateJogador(Jogador jogador);

	void deleteAllJogadorById(Integer id);

	void deleteJogadorById(Integer id);

	void deleteAllJogador();

	void updateJogadorById(Integer id, Jogador jogador);

}
