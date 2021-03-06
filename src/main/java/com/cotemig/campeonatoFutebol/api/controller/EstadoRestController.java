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

import com.cotemig.campeonatoFutebol.model.Cidade;
import com.cotemig.campeonatoFutebol.model.Estado;
import com.cotemig.campeonatoFutebol.service.CidadeService;
import com.cotemig.campeonatoFutebol.service.EstadoService;

/**
 * @author equipe devs
 *
 */
@RestController
@RequestMapping("/estado/rest")
public class EstadoRestController {

	@Autowired
	private CidadeService cidadeService;

	@Autowired
	private EstadoService estadoService;

	@RequestMapping(value = "/{id}/get", method = RequestMethod.GET)
	public Optional<Estado> getEstado(@PathVariable("id") Integer id) {
		return estadoService.getEstadoById(id);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Estado> getEstados() {
		return estadoService.getAllEstados();
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public void insertEstado(@RequestBody Estado estado) {
		estadoService.insertEstado(estado);
	}

	@RequestMapping(value = "/{idEstado}/getAllCidades", method = RequestMethod.GET)
	public List<Cidade> getAllCidadesByEstado(@PathVariable("idEstado") Integer idEstado) {
		return cidadeService.getAllCidadesByEstado(idEstado);
	}

}
