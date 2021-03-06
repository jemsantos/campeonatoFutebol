/**
 * 
 */
package com.cotemig.campeonatoFutebol.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cotemig.campeonatoFutebol.model.Classificacao;
import com.cotemig.campeonatoFutebol.model.Equipe;
import com.cotemig.campeonatoFutebol.model.Jogador;
import com.cotemig.campeonatoFutebol.service.ClassificacaoService;
import com.cotemig.campeonatoFutebol.service.EquipeService;
import com.cotemig.campeonatoFutebol.service.JogadorService;

/**
 * @author equipe devs
 *
 */
@RestController
@RequestMapping("/equipe/rest")
public class EquipeRestController {

	@Autowired
	private JogadorService jogadorService;

	@Autowired
	private ClassificacaoService classificacaoService;

	@Autowired
	private EquipeService equipeService;

	@RequestMapping(value = "/{id}/get", method = RequestMethod.GET)
	public Optional<Equipe> getEquipe(@PathVariable("id") Integer id) {
		return equipeService.getEquipeById(id);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Equipe> getEquipes() {
		return equipeService.getAllEquipes();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertEquipe(@RequestBody Equipe equipe) {
		equipeService.insertEquipe(equipe);
	}

	@RequestMapping(value = "/{idEquipe}/getAllJogadores", method = RequestMethod.GET)
	public List<Jogador> getAllJogadoresByEquipe(@PathVariable("idEquipe") Integer idEquipe) {
		return jogadorService.getAllJogadoresByEquipe(idEquipe);
	}

	@RequestMapping(value = "/{idEquipe}/getClassificacoes", method = RequestMethod.GET)
	public Optional<Classificacao> getClassificacaoByEquipe(@PathVariable("idEquipe") Integer idEquipe) {
		return classificacaoService.getClassificacaoByEquipe(idEquipe);
	}

}
