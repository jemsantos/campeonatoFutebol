/**
 * 
 */
package com.cotemig.campeonatoFutebol.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cotemig.campeonatoFutebol.model.Estadio;
import com.cotemig.campeonatoFutebol.repository.EstadioRepository;

/**
 * @author equipe devs
 *
 */
@Service("estadioService")
public class EstadioServiceImpl implements EstadioService {

	@Autowired
	EstadioRepository estadioRepository;

	@Override
	public Optional<Estadio> getEstadioById(Integer id) {
		return estadioRepository.findById(id);
	}

	@Override
	public List<Estadio> getAllEstadiosByCidade(Integer idCidade) {
		return estadioRepository.getAllEstadiosByCidade(idCidade);
	}

	@Override
	public List<Estadio> getAllEstadios() {
		return estadioRepository.findAll();
	}

	@Override
	public void insertEstadio(Estadio estadio) {
		estadioRepository.save(estadio);
	}

	@Override
	public List<Estadio> getAllEstadio() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllEstadios() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEstadioById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEstadioById(Integer id, Estadio estadio) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEstadio(Estadio estadio) {
		// TODO Auto-generated method stub

	}

}
