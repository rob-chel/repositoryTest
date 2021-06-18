package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.uniroma3.siw.spring.model.Istruttore;

public interface IstruttoreRepository extends CrudRepository<Istruttore, Long>{
	
	public List<Istruttore> findByNome(String nome);


}
