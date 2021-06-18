package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Prenotazione;

public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>{
	
	public List<Prenotazione> findByNomeCliente(String nomeCliente);

	public List<Prenotazione> findByNomeClienteAndCognomeCliente(String nomeCliente, String cognomeCliente);

	public List<Prenotazione> findByNomeClienteOrCognomeCliente(String nomeCliente, String cognomeCliente);
	

}
