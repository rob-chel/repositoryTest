package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Istruttore;
import it.uniroma3.siw.spring.repository.IstruttoreRepository;



@Service
public class IstruttoreService {
	
	@Autowired
	private IstruttoreRepository istruttoreRepository; 
	
	@Transactional
	public Istruttore inserisci(Istruttore istruttore) {
		return istruttoreRepository.save(istruttore);
	}
	
	@Transactional
	public List<Istruttore> istruttorePerNome(String nome) {
		return istruttoreRepository.findByNome(nome);
	}

	@Transactional
	public List<Istruttore> tutti() {
		return (List<Istruttore>) istruttoreRepository.findAll();
	}

	@Transactional
	public Istruttore collezionePerId(Long id) {
		Optional<Istruttore> optional = istruttoreRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Istruttore istruttore) {
		List<Istruttore> istruttori = this.istruttoreRepository.findByNome(istruttore.getNome());
		if (istruttori.size() > 0)
			return true;
		else 
			return false;
	}


}
