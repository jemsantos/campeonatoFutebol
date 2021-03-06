/**
 * 
 */
package com.cotemig.campeonatoFutebol.controller;

import javax.validation.Valid;

import com.cotemig.campeonatoFutebol.model.Jogador;
import com.cotemig.campeonatoFutebol.service.EquipeService;
import com.cotemig.campeonatoFutebol.service.JogadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author equipe devs
 *
 */
@RestController
public class JogadorController {

	@Autowired
	private JogadorService jogadorService;

	@Autowired
	private EquipeService equipeService;

	@RequestMapping(value = "/jogador/all", method = RequestMethod.GET)
	public ModelAndView list() {
		return new ModelAndView("jogador/Jogador", "jogadores", jogadorService.getAllJogadores());
	}
	
	// ROTA INSERT JOGADOR
	@RequestMapping(value = "/jogador/insert", method = RequestMethod.GET)
	public ModelAndView insertJogador() {

		ModelAndView mav = new ModelAndView("jogador/insert");

		mav.addObject("jogador", new Jogador());
		mav.addObject("equipes", equipeService.getAllEquipes());

		return mav;
	}

	@RequestMapping(value = "/jogador/insert", method = RequestMethod.POST)
	public String submitInsert(@Valid @ModelAttribute("jogador") Jogador jogador, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}
		
		jogadorService.insertJogador(jogador);

		return "redirect:/jogador/Jogador";
	}
	
	// ROTA DELETE
	@RequestMapping(value = "/jogador/{id}/delete", method = RequestMethod.GET)
	public ModelAndView delete(Integer id) {

		return new ModelAndView("jogador/delete", "jogador", jogadorService.getJogadorById(id).get());
	}

	@RequestMapping(value = "/jogador/delete", method = RequestMethod.POST)
	public String submitDelete(@Valid @ModelAttribute("jogador") Jogador jogador, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		jogadorService.deleteJogadorById(jogador.getId());

		return "redirect:/jogador/Jogador";
	}

	// ROTA UPDATE

	@RequestMapping(value = "/jogador/update", method = RequestMethod.GET)
	public ModelAndView update(Integer id) {

//		return new ModelAndView("jogador/update", "jogador", jogadorService.getJogadorById(id).get());
		ModelAndView mav = new ModelAndView("jogador/update");
		mav.addObject("jogador", jogadorService.getJogadorById(id).get());
		return mav;
	}

	@RequestMapping(value = "/jogador/update", method = RequestMethod.POST)
	public String submitUpdate(@Valid @ModelAttribute("jogador") Jogador jogador, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}

		jogadorService.updateJogador(jogador);

		return "redirect:/jogador/Jogador";
	}

	@RequestMapping(value = "/jogador/read", method = RequestMethod.GET)
	public ModelAndView read() {

		ModelAndView mav = new ModelAndView("jogador/read");
		mav.addObject("jogadores", jogadorService.getAllJogadores());
		return mav;
	}

}
