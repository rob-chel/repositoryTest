package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.service.CorsoService;
import it.uniroma3.siw.spring.service.PrenotazioneService;
import it.uniroma3.siw.spring.validator.PrenotazioneValidator;

@Controller
public class PrenotazioneController {
	
	@Autowired
	private PrenotazioneService prenService;
	
	@Autowired
	private PrenotazioneValidator prenotazioneValidator;
	
	@Autowired
	private CorsoService corsoService;
	
	@RequestMapping(value="/prenotazione",method = RequestMethod.GET)
	public String addPrenotazione(Model model) {
		model.addAttribute("prenotazione",new Prenotazione());
		return "formPrenotazione.html";
	}
	
	@RequestMapping(value = "/prenotazione", method = RequestMethod.POST)
    public String newPrenotazione(@ModelAttribute("prenotazione") Prenotazione prenotazione, 
    									Model model, BindingResult bindingResult) {
    	this.prenotazioneValidator.validate(prenotazione, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.prenService.inserisci(prenotazione);
            return "prenRiuscita.html";
        }
        return "formPrenotazione.html";
    }
	
	
	
	

}
