package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Sala;
import it.uniroma3.siw.spring.repository.SalaRepository;



@Service
public class SalaService {
	
	@Autowired
	private SalaRepository salaRepository; 
	
	@Transactional
	public Sala inserisci(Sala sala) {
		return salaRepository.save(sala);
	}
	
	@Transactional
	public List<Sala> corsoPerNome(String nome) {
		return salaRepository.findByNome(nome);
	}

	@Transactional
	public List<Sala> tutti() {
		return (List<Sala>) salaRepository.findAll();
	}

	@Transactional
	public Sala corsoPerId(Long id) {
		Optional<Sala> optional = salaRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Sala sala) {
		List<Sala> sale = this.salaRepository.findByNome(sala.getNome());
		if (sale.size() > 0)
			return true;
		else 
			return false;
	}


}
