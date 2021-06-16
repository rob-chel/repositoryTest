package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	
	@Autowired
	private PrenotazioneRepository prenRepository; 
	
	@Transactional
	public List<Prenotazione> tutti() {
		return (List<Prenotazione>) prenRepository.findAll();
	}
	
	@Transactional
	public Prenotazione personaPerId(Long id) {
		Optional<Prenotazione> optional = prenRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}
	
	@Transactional
	public Prenotazione inserisci(Prenotazione prenotazione) {
		return prenRepository.save(prenotazione);
	}

	@Transactional
	public boolean alreadyExists(Prenotazione prenotazione) {
		List<Prenotazione> prenotazioni = this.prenRepository.findByNomeVisitatoreAndCognomeVisitatore(prenotazione.getNomeVisitatore(), prenotazione.getCognomeVisitatore());
		if (prenotazioni.size() > 0)
			return true;
		else 
			return false;
	}

}
