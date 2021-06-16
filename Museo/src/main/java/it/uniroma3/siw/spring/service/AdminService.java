package it.uniroma3.siw.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.repository.CollezioneRepository;
import it.uniroma3.siw.spring.repository.OperaRepository;

@Service
public class AdminService {
	
	@Autowired
	private CollezioneRepository collezioneRepository;
	
	@Autowired
	private OperaRepository operaRepository;

}
