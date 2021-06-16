package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.uniroma3.siw.spring.model.Prenotazione;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>{
	
	public List<Prenotazione> findByNomeVisitatore(String nome);

	public List<Prenotazione> findByNomeVisitatoreAndCognomeVisitatore(String nomeVisitatore, String cognomeVisitatore);

	public List<Prenotazione> findByNomeVisitatoreOrCognomeVisitatore(String nomeVisitatore, String cognomeVisitatore);
	

}
