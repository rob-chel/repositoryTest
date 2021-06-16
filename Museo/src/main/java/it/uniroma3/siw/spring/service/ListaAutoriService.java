package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.repository.ListaAutoriRepository;


@Service
public class ListaAutoriService {
	
	@Autowired
	private ListaAutoriRepository artistiRepository; 
	
	@Transactional
	public List<Artista> tutti() {
		return (List<Artista>) artistiRepository.findAll();
	}
	
	@Transactional
	public Artista personaPerId(Long id) {
		Optional<Artista> optional = artistiRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}
	
	

}
